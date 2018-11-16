package com.yatra;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import com.example.Customer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class ProducerSchemaRegistry {

	public static void main(String[] args) {
		try {
			Customer.Builder customBuilder = Customer.newBuilder();
			customBuilder.setAge(1);
			customBuilder.setFirstName("John");
			customBuilder.setLastName("Doe");
			customBuilder.setHeight(334.3f);
			customBuilder.setWeight(7609.8f);
			customBuilder.setAutomatedEmail(false);

			Customer c = customBuilder.build();
			Properties properties = new Properties();
			properties.put("bootstrap.servers", "192.168.19.71:9092");
			properties.put("acks", "1");
			properties.put("value.serializer", StringSerializer.class.getName());
			properties.put("key.serializer", StringSerializer.class.getName());
			// properties.put("schema.registry.url", "http://localhost:6061");
			KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("test_kalyan", "1",
					"Hello");

			Future<RecordMetadata> recordMetaData = kafkaProducer.send(producerRecord);
			RecordMetadata r = recordMetaData.get();
			System.out.println(r.timestamp());
			kafkaProducer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
