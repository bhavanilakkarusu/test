package com.yatra;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ConsumerSchemaRegistry {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.19.71:9092");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.CLIENT_ID_CONFIG, "1234");
		props.put("enable.auto.commit", "false");

		final Consumer<String, String> consumer = new KafkaConsumer(props);
		consumer.subscribe(Collections.singletonList("billing_entity_params"));
		consumer.seekToBeginning(consumer.assignment());
		System.out.println("polling");
		ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
		for (ConsumerRecord consumerRecord : consumerRecords) {
			System.out.println(consumerRecord.topic() + "" + consumerRecord.partition() + " " + consumerRecord.value());
		}
		consumer.close();
	}

}
