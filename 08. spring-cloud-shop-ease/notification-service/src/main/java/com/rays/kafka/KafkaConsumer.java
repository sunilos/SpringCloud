package com.rays.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rays.details.OrderDetails;
import com.rays.mail.EmailService;

@Service
public class KafkaConsumer {

	@Autowired
	private EmailService emailService;

	@KafkaListener(topics = "order-topic", groupId = "email-group")
	public void receiveOrderDetails(OrderDetails orderDetails) {
		System.out.println("Order Received - Items: " + orderDetails.getItems());
		System.out.println("Customer Email: " + orderDetails.getEmail());

		String subject = "Order Confirmation";
		String body = "Your order for " + orderDetails.getItems() + " items has been successfully placed.";

		emailService.sendEmail(orderDetails.getEmail(), subject, body);
	}
}
