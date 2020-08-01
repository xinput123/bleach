package com.bleach;

import com.bleach.consts.KafkaConsts;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;


public class KafkaUtils {

    private static Logger logger = LoggerFactory.getLogger(KafkaUtils.class);

    private static Properties kafkaConfig;
    private static KafkaProducer producer;

    static {
        kafkaConfig = KafkaConsts.kafkaProperties.getPropertyGroup(KafkaConsts.KAFKA_PREFIX, true);
    }

    public static KafkaConsumer createConsumer(String topic) {
        KafkaConsumer consumer = new KafkaConsumer(kafkaConfig);
        consumer.subscribe(Arrays.asList(topic));
        return consumer;
    }

    public static KafkaProducer createProducer() {
        if (producer == null) {
            producer = new KafkaProducer(kafkaConfig);
        }
        return producer;
    }

    public static void send(Object notify, String topic) {
        if (notify == null) {
            logger.error("发送消息不能为空");
            return;
        }
        createProducer();
        String msg;
        if (notify instanceof String) {
            msg = String.valueOf(notify);
        } else {
            msg = JsonUtils.toJsonString(notify);
        }
        producer.send(new ProducerRecord<String, String>(topic, msg), (recordMetadata, e) -> {
            if (e != null) {
                logger.error("send notify to topic {} failed.notify :{}", topic, msg, e);
            } else {
                logger.info("send notify to topic {} success.notify:{}", topic, msg, e);
            }
        });
    }


}
