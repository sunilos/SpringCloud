package com.rays.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling payment-related requests.
 * This RESTful API allows users to make payments and check service status.
 */
@RestController
@RequestMapping(value = "PaymentCtl")
public class PaymentCtl {

    /**
     * The initial balance, default value set to 100.
     */
	@Value(value = "100")
    private double balance;

    /**
     * Handles a payment request by deducting the specified amount from the balance.
     *
     * @param amt The amount to be deducted from the balance.
     * @return The updated balance after the payment.
     */
	@PostMapping("makePayment")
	public double makePayment(@RequestParam double amt) {
        balance -= amt;
		return balance;
	}

    /**
     * Health check endpoint to verify if the service is running.
     *
     * @return A status message confirming the service is running.
     */
    @GetMapping
    public String get() {
        return this.getClass().getName() + ": I am fit and fine, and I am running.";
    }
}
