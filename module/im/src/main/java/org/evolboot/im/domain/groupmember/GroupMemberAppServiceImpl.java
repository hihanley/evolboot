package org.evolboot.im.domain.groupmember;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.data.Page;
import org.evolboot.im.domain.groupmember.entity.GroupMember;
import org.evolboot.im.domain.groupmember.repository.GroupMemberRepository;
import org.evolboot.im.domain.groupmember.service.GroupMemberCreateFactory;
import org.evolboot.im.domain.groupmember.service.GroupMemberQuery;
import org.evolboot.im.domain.groupmember.service.GroupMemberSupportService;
import org.evolboot.im.domain.groupmember.service.GroupMemberUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 群成员
 *
 * @author evol
 * @date 2023-05-03 16:20:09
 */
@Slf4j
@Service
public class GroupMemberAppServiceImpl extends GroupMemberSupportService implements GroupMemberAppService {


    private final GroupMemberCreateFactory factory;
    private final GroupMemberUpdateService updateService;

    protected GroupMemberAppServiceImpl(GroupMemberRepository repository, GroupMemberCreateFactory factory, GroupMemberUpdateService updateService) {
        super(repository);
        this.factory = factory;
        this.updateService = updateService;
    }

    @Override
    @Transactional
    public GroupMember create(GroupMemberCreateFactory.Request request) {
        return factory.execute(request);
    }


    @Override
    @Transactional
    public void update(GroupMemberUpdateService.Request request) {
        updateService.execute(request);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }


}
