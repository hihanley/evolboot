package org.evolboot.identity.domain.user.service;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.identity.acl.client.SecurityAccessTokenClient;
import org.evolboot.identity.domain.user.entity.User;
import org.evolboot.identity.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色删除时，删除对应人员的角色
 *
 * @author evol
 */
@Service
@Slf4j
public class UserRoleDeleteService extends UserSupportService {
    private final SecurityAccessTokenClient securityAccessTokenClient;


    public UserRoleDeleteService(UserRepository repository, SecurityAccessTokenClient securityAccessTokenClient) {


        super(repository);
        this.securityAccessTokenClient = securityAccessTokenClient;
    }

    public void deleteRoleId(Long roleId) {
        List<User> users = repository.findAll(UserQuery.builder().roleId(roleId).build());
        if (users.isEmpty()) {
            return;
        }
        users.forEach(user -> {
            // 移除角色
            user.removeRoleId();
            // 踢下线
            securityAccessTokenClient.kickOut(user.getId());
        });
        repository.saveAll(users);
    }
}