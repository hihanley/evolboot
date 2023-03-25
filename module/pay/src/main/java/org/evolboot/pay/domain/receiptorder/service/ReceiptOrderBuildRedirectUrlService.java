package org.evolboot.pay.domain.receiptorder.service;

import org.evolboot.core.service.RedisClientAppService;
import org.evolboot.core.util.JsonUtil;
import org.evolboot.pay.domain.paygatewayaccount.PayGatewayAccount;
import org.evolboot.pay.domain.paygatewayaccount.PayGatewayAccountAppService;
import org.evolboot.pay.domain.paymentclient.receipt.ReceiptClient;
import org.evolboot.pay.domain.paymentclient.receipt.ReceiptRedirectNotifyRequest;
import org.evolboot.pay.domain.paymentclient.receipt.ReceiptRedirectNotifyResponse;
import org.evolboot.pay.domain.receiptorder.ReceiptOrder;
import org.evolboot.pay.domain.receiptorder.repository.ReceiptOrderRepository;
import org.evolboot.shared.cache.RedisCacheName;
import org.evolboot.shared.pay.PayGateway;
import org.evolboot.shared.pay.ReceiptOrderStatus;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhangsan
 */
@Service
@Slf4j
public class ReceiptOrderBuildRedirectUrlService extends ReceiptOrderSupportService {

    private final RedisClientAppService redisClientAppService;

    private final Map<PayGateway, ReceiptClient> receiptClients;

    private final PayGatewayAccountAppService payGatewayAccountAppService;

    protected ReceiptOrderBuildRedirectUrlService(ReceiptOrderRepository repository, RedisClientAppService redisClientAppService, Map<PayGateway, ReceiptClient> receiptClients, PayGatewayAccountAppService payGatewayAccountAppService) {
        super(repository);
        this.redisClientAppService = redisClientAppService;
        this.receiptClients = receiptClients;
        this.payGatewayAccountAppService = payGatewayAccountAppService;
    }


    public <T extends ReceiptRedirectNotifyRequest> String getReceiptRedirectUrl(T request) {
        log.info("代收:前端回调:{}", JsonUtil.stringify(request));
        ReceiptOrder receiptOrder = findById(request.getReceiptOrderId());
        PayGatewayAccount payGatewayAccount = payGatewayAccountAppService.findById(receiptOrder.getPayGatewayAccountId());
        log.info("代收:前端回调:{}", payGatewayAccount.getPayGateway());
        ReceiptClient receiptClient = receiptClients.get(payGatewayAccount.getPayGateway());
        ReceiptRedirectNotifyResponse response = receiptClient.receiptOrderRedirectNotify(payGatewayAccount, request);

        String redirectUrl = receiptOrder.getRedirectUrl();
        Map<String, String> params = Maps.newHashMap();
        params.put("internalOrderId", receiptOrder.getInternalOrderId());
        params.put("status", response.getStatus().name());
        redisClientAppService.set(RedisCacheName.PAY_RECEIPT_REDIRECT_URL_CACHE_KEY + receiptOrder.getInternalOrderId(), params, 60);
        log.info("前端跳转链接:{},{},{}", receiptOrder.id(), receiptOrder.getPayGateway(), redirectUrl);

        return redirectUrl;
    }
}