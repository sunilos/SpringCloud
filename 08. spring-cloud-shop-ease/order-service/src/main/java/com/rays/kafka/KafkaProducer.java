package com.rays.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.rays.details.OrderDetails;

@Service
public class KafkaProducer {

	@Autowired
	KafkaTemplate<String, Object> template;

	public void sendDetails(OrderDetails orderDetails) {
		template.send("order-topic", orderDetails);
	}
}
