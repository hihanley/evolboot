package org.evolboot.mq.redis.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author evol
 */
@Component
@Slf4j
public class RedisDelayTimeListenerMessage implements StreamListener<String, MapRecord<String, String, String>> {


    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        String key = message.getValue().keySet().stream().findFirst().get();
        log.info("消息队列:Redis:延时消息:{},{},不用管,等待定时处理", message.getId(), key);
    }


}
