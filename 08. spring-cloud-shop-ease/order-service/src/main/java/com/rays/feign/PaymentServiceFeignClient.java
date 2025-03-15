package com.rays.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The {@code PaymentServiceFeignClient} interface defines a Feign client for interacting
 * with the Payment Service. It provides a method to process payments.
 * 
 * <p>
 * Annotations used:
 * <ul>
 *   <li>{@link FeignClient} - Declares this interface as a Feign client for the Payment Service.</li>
 *   <li>{@link PostMapping} - Maps an HTTP POST request to a specific endpoint.</li>
 *   <li>{@link RequestParam} - Binds request parameters to method parameters.</li>
 * </ul>
 * </p>
 *
 * @author Sunil OS
 * @version 1.0
 * @since 2025-03-15
 */
@FeignClient(name = "payment-service", url = "http://localhost:8082")
public interface PaymentServiceFeignClient {

    /**
     * Calls the Payment Service to process a payment.
     *
     * @param amt The amount to be paid.
     * @return The updated balance or payment confirmation.
     */
    @PostMapping("/payment-service/PaymentCtl/makePayment")
    double makePayment(@RequestParam("amt") double amt);
}
