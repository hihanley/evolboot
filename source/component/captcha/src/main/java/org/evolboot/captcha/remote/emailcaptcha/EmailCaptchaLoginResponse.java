package org.evolboot.captcha.remote.emailcaptcha;

import org.evolboot.captcha.domain.emailcaptcha.EmailCaptcha;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author evol
 */
@Getter
@Builder
@ToString
public class EmailCaptchaLoginResponse {
    private String email;
    private String token;
    private Long interval;
    private Long expires;

    public static EmailCaptchaLoginResponse of(EmailCaptcha emailCaptcha) {

        return EmailCaptchaLoginResponse.builder()
                .email(emailCaptcha.getEmail())
                .token(emailCaptcha.getToken())
                .interval(emailCaptcha.getInterval())
                .expires(emailCaptcha.getExpires())
                .build();
    }
}
