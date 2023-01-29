package org.evolboot.identity.acl.adapter;

import org.evolboot.captcha.domain.emailcaptcha.EmailCaptcha;
import org.evolboot.captcha.domain.emailcaptcha.EmailCaptchaAppService;
import org.evolboot.captcha.domain.emailcaptcha.EmailCaptchaCreateFactory;
import org.evolboot.captcha.domain.mobilecaptcha.MobileCaptcha;
import org.evolboot.captcha.domain.mobilecaptcha.MobileCaptchaAppService;
import org.evolboot.captcha.domain.mobilecaptcha.MobileCaptchaCreateFactory;
import org.evolboot.identity.acl.port.IdentityCaptchaPort;
import org.evolboot.shared.email.MessageTag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author evol
 * 
 */
@Service
@Slf4j
public class IdentityCaptchaAdapter implements IdentityCaptchaPort {

    private final MobileCaptchaAppService mobileCaptchaAppService;
    private final EmailCaptchaAppService emailCaptchaAppService;


    public IdentityCaptchaAdapter(MobileCaptchaAppService mobileCaptchaAppService, EmailCaptchaAppService emailCaptchaAppService) {
        this.mobileCaptchaAppService = mobileCaptchaAppService;
        this.emailCaptchaAppService = emailCaptchaAppService;
    }

    @Override
    public void verifyMobileCaptchaIsTrue(String mobilePrefix,
                                          String mobile,
                                          String mobileCaptchaCode,
                                          String mobileCaptchaToken,
                                          String internalCode) {
        mobileCaptchaAppService.verifyIsTrue(mobilePrefix, mobile, mobileCaptchaToken, mobileCaptchaCode, internalCode);
    }

    @Override
    public String sendMobileCaptcha(String mobilePrefix,
                                    String mobile,
                                    org.evolboot.shared.sms.MessageTag messageTag,
                                    String ip,
                                    String internalCode) {
        MobileCaptcha mobileCaptcha = mobileCaptchaAppService.create(MobileCaptchaCreateFactory
                .Request
                .builder()
                .mobilePrefix(mobilePrefix)
                .mobile(mobile)
                .messageTag(messageTag)
                .internalCode(internalCode)
                .verifyImageCaptcha(false)
                .ip(ip)
                .build());
        return mobileCaptcha.getToken();
    }

    @Override
    public void verifyEmailCaptchaIsTrue(String email, String emailCaptchaCode, String emailCaptchaToken, String internalCode) {
        emailCaptchaAppService.verifyIsTrue(emailCaptchaToken, email, emailCaptchaCode, internalCode);
    }

    @Override
    public String sendEmailCaptcha(String email, MessageTag messageTag, String ip, String internalCode) {
        EmailCaptcha emailCaptcha = emailCaptchaAppService.create(
                EmailCaptchaCreateFactory
                        .Request
                        .builder()
                        .email(email)
                        .messageTag(messageTag)
                        .ip(ip)
                        .verifyImageCaptcha(false)
                        .internalCode(internalCode)
                        .build()
        );
        return emailCaptcha.getToken();
    }
}
