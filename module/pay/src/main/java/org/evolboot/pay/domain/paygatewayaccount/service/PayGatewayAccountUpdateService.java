package org.evolboot.pay.domain.paygatewayaccount.service;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.pay.domain.paygatewayaccount.entity.PayGatewayAccount;
import org.evolboot.pay.domain.paygatewayaccount.repository.PayGatewayAccountRepository;
import org.springframework.stereotype.Service;

/**
 * 支付网关账户
 *
 * @author evol
 */
@Slf4j
@Service
public class PayGatewayAccountUpdateService extends PayGatewayAccountSupportService {
    protected PayGatewayAccountUpdateService(PayGatewayAccountRepository repository) {
        super(repository);
    }

    public void execute(Long id, Request request) {
        PayGatewayAccount payGatewayAccount = findById(id);
        payGatewayAccount.setLogo(request.getLogo());
        payGatewayAccount.setMerchantId(request.getMerchantId());
        payGatewayAccount.setAppid(request.getAppid());
        payGatewayAccount.setSecretKey(request.getSecretKey());
        payGatewayAccount.setMinimumReceipt(request.getMinimumReceipt());
        payGatewayAccount.setMaximumReceipt(request.getMaximumReceipt());
        payGatewayAccount.setEnable(request.getEnable());
        payGatewayAccount.setPayGateway(request.getPayGateway());
        payGatewayAccount.setLocales(request.getLocales());
        payGatewayAccount.setSort(request.getSort());
        payGatewayAccount.setWalletId(request.getWalletId());
        payGatewayAccount.setAlias(request.getAlias());
        repository.save(payGatewayAccount);
    }

    public static class Request extends PayGatewayAccountRequestBase {
    }

}