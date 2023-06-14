package org.evolboot.pay.domain.receiptorder;

import org.evolboot.core.data.Page;
import org.evolboot.pay.domain.receiptorder.entity.ReceiptOrder;
import org.evolboot.pay.domain.receiptorder.service.ReceiptOrderQuery;

import java.util.Optional;
import java.util.List;

/**
 * 查询服务 第三方代收订单
 *
 * @author evol
 * @date 2023-06-14 20:22:47
 */
public interface ReceiptOrderQueryService {

    ReceiptOrder findById(String id);

    List<ReceiptOrder> findAll();

    List<ReceiptOrder> findAll(ReceiptOrderQuery query);

    Page<ReceiptOrder> page(ReceiptOrderQuery query);


    /**
     * 根据条件查询单个
     *
     * @param query
     * @return
     */
    Optional<ReceiptOrder> findOne(ReceiptOrderQuery query);


}
