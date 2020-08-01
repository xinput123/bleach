package com.bleach.consts;

import com.bleach.SimpleProperties;

/**
 * @author zanxus
 * @version 1.0.0
 * @date 2018-05-03 10:33
 * @description
 */
public class KafkaConsts {

    private static final String KAFKA_CONF_FILE = "kafka.properties";

    public static final String KAFKA_PREFIX = "kafka";

    public static SimpleProperties kafkaProperties = SimpleProperties.readConfiguration(KAFKA_CONF_FILE);

}
