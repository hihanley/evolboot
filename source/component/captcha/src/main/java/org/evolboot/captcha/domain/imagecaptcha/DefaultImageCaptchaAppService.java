package org.evolboot.captcha.domain.imagecaptcha;

import org.evolboot.captcha.CaptchaI18nMessage;
import org.evolboot.captcha.domain.imagecaptcha.repository.ImageCaptchaRepository;
import org.evolboot.core.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author evol
 * 
 */
@Service
@Slf4j
public class DefaultImageCaptchaAppService implements ImageCaptchaAppService {

    private final ImageCaptchaCreateFactory service;

    private final ImageCaptchaRepository repository;

    private final ImageCaptchaVerifyService imageCaptchaVerifyService;


    public DefaultImageCaptchaAppService(ImageCaptchaCreateFactory service, ImageCaptchaRepository repository, ImageCaptchaVerifyService imageCaptchaVerifyService) {
        this.service = service;
        this.repository = repository;
        this.imageCaptchaVerifyService = imageCaptchaVerifyService;
    }

    @Transactional
    @Override
    public ImageCaptchaCreateFactory.Response create(Integer width, Integer height, String ip) {
        return service.create(width, height, ip);
    }

    @Override
    public boolean verify(String token, String codeValue) {
        return imageCaptchaVerifyService.execute(token, codeValue);
    }


    @Override
    public void verifyIsTrue(String token, String codeValue) {
        boolean verifyResult = imageCaptchaVerifyService.execute(token, codeValue);
        Assert.isTrue(verifyResult, CaptchaI18nMessage.ImageCaptcha.codeError());
    }

}
