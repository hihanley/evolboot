package org.evolboot.pay.domain.paygatewayaccount;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.data.Page;
import org.evolboot.pay.domain.paygatewayaccount.entity.PayGatewayAccount;
import org.evolboot.pay.domain.paygatewayaccount.repository.PayGatewayAccountRepository;
import org.evolboot.pay.domain.paygatewayaccount.service.PayGatewayAccountCreateFactory;
import org.evolboot.pay.domain.paygatewayaccount.service.PayGatewayAccountQuery;
import org.evolboot.pay.domain.paygatewayaccount.service.PayGatewayAccountSupportService;
import org.evolboot.pay.domain.paygatewayaccount.service.PayGatewayAccountUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.evolboot.pay.exception.PayException.GATEWAY_NOT_FOUND;

/**
 * 支付网关账户
 *
 * @author evol
 */
@Slf4j
@Service
public class PayGatewayAccountAppServiceImpl implements PayGatewayAccountAppService {


    private final PayGatewayAccountCreateFactory factory;
    private final PayGatewayAccountUpdateService updateService;

    private final PayGatewayAccountRepository repository;

    private final PayGatewayAccountSupportService supportService;

    protected PayGatewayAccountAppServiceImpl(PayGatewayAccountRepository repository, PayGatewayAccountCreateFactory factory, PayGatewayAccountUpdateService updateService, PayGatewayAccountSupportService supportService) {
        this.factory = factory;
        this.updateService = updateService;
        this.repository = repository;
        this.supportService = supportService;
    }


    @Override
    @Transactional
    public PayGatewayAccount create(PayGatewayAccountCreateFactory.Request request) {
        return factory.execute(request);
    }


    @Override
    @Transactional
    public void update(PayGatewayAccountUpdateService.Request request) {
        updateService.execute(request);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        supportService.findById(id);
        repository.deleteById(id);
    }


}
