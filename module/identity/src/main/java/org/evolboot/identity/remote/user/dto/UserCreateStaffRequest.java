package org.evolboot.identity.remote.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.evolboot.identity.IdentityI18nMessage;
import org.evolboot.identity.domain.user.entity.Gender;
import org.evolboot.identity.domain.user.entity.UserStatus;
import org.evolboot.identity.domain.user.service.UserCreateFactory;
import org.evolboot.shared.lang.UserIdentity;

import javax.validation.constraints.NotEmpty;

/**
 * @author evol
 */
@Data
public class UserCreateStaffRequest {

    @NotEmpty(message = IdentityI18nMessage.User.USERNAME_NOT_EMPTY)
    @Schema(description = "用户名", example = "evol")
    private String username;


    private String nickname;

    private String mobile;
    private String email;
    private Gender gender;
    private UserStatus status;
    @NotEmpty(message = IdentityI18nMessage.User.PASSWORD_NOT_EMPTY)
    @Schema(description = "密码", example = "ZX1Oqhh/Sjnlv7oa5U8mj7ubt5YXcThTAeOcQI0BfI6+bg4goxBQjakLbLbI6u2OnEkbsOkv4YGgOOi+1gnRNMgdYwdUqWfL99mmwhHAksSlQNR3Byu7a5GJeS3G2abyf4Gu2TayRX8xFkSwv1ze+PioM+fvITC6Zmm38g7ClLw=")
    private String password;


    private String remark;

    private Long roleId;


    public UserCreateFactory.Request to(String ip) {
        return UserCreateFactory
                .Request
                .builder()
                .username(username)
                .nickname(nickname)
                .encodePassword(password)
                .mobile(mobile)
                .email(email)
                .gender(gender)
                .status(status)
                .remark(remark)
                .roleId(roleId)
                .userIdentity(UserIdentity.ROLE_STAFF)
                .registerIp(ip)
                .build();
    }


}