package com.rays.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "PaymentCtl")
public class PaymentCtl {

	@Value(value = "100")
	double balance = 0;

	@PostMapping("makePayment")
	public double makePayment(@RequestParam double amt) {
		balance = balance - amt;
		return balance;
	}
}
