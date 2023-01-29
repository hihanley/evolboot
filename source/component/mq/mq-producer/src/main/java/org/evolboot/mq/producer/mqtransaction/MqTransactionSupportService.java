package org.evolboot.mq.producer.mqtransaction;

import org.evolboot.mq.producer.mqtransaction.repository.MqTransactionRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Mq事务
 *
 * @author evol
 */
@Slf4j
public abstract class MqTransactionSupportService {

    final MqTransactionRepository repository;

    protected MqTransactionSupportService(MqTransactionRepository repository) {
        this.repository = repository;
    }



}
