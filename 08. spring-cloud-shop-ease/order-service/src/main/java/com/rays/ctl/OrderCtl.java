package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.details.OrderDetails;
import com.rays.feign.InventoryServiceFeignClient;
import com.rays.feign.PaymentServiceFeignClient;
import com.rays.kafka.KafkaProducer;

@RestController
@RequestMapping(value = {"OrderCtl","ctl/order"})
public class OrderCtl {

	@Autowired
	public PaymentServiceFeignClient paymentService;

	@Autowired
	public InventoryServiceFeignClient inventoryService;

	@Autowired
	KafkaProducer producer;
	
	@GetMapping
	public String get() {
		return  this.getClass().getName() +  ": I am fit and fine, and I am running.";
	}
	

	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody OrderDetails orderDetails) {

		int price = 10;

		int quantity = orderDetails.getItems();

		double totalAmount = quantity * price;

		double updatedBalance = paymentService.makePayment(totalAmount);

		int updatedStock = inventoryService.sold(quantity);

		System.out.println("Tickets are Booked");
		System.out.println("Total Amount Paid: " + totalAmount);
		System.out.println("Remaining Balance: " + updatedBalance);
		System.out.println("Updated Stock: " + updatedStock);

		String message = "Tickets are Booked | Total Amount Paid: " + totalAmount + " | Remaining Balance: "
				+ updatedBalance + " | Updated Stock: " + updatedStock;

		//producer.sendDetails(orderDetails);

		return message;
	}
}