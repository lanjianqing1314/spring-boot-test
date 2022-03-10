package com.example.demoflinkcdckafkamysql.utils;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

/**
 * @author 兰建青
 * @title: KafkaUtil
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2022/3/90:21
 */
public class KafkaUtil {
    private static final String KAFKA_SERVER = "myip:9092,myip:9094";
    private static Properties properties = new Properties();
    static {
        properties.setProperty("bootstrap.servers", KAFKA_SERVER);
    }
    public static FlinkKafkaProducer<String> getKafkaSink(String topic) {
        return new FlinkKafkaProducer<>(topic,new SimpleStringSchema(),properties);
    }
}
