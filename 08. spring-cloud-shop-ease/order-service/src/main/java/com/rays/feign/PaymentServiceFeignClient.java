package com.rays.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-service", url = "http://localhost:8082")
public interface PaymentServiceFeignClient {

	@PostMapping("/payment-service/PaymentCtl/makePayment")
	public double makePayment(@RequestParam("amt") double amt);

}