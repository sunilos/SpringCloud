package com.sunilos.ctl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@Controller
public class PaymentCtl {

	@Value("${razorpay.key.id}")
	private String keyId;

	@Value("${razorpay.key.secret}")
	private String keySecret;

	@GetMapping("/pay")
	public String makePayment(Model model) {
		try {
			RazorpayClient razorpayClient = new RazorpayClient(keyId, keySecret);

			JSONObject options = new JSONObject();

			options.put("amount", 100);
			options.put("currency", "INR");
			options.put("receipt", "txn_" + System.currentTimeMillis());

			Order order = razorpayClient.Orders.create(options);

			model.addAttribute("orderId", order.get("id"));
			model.addAttribute("key", "RAZORPAY_KEY_ID");
			model.addAttribute("amount", order.get("amount"));

		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		return "Payment";
	}

	@PostMapping("/verify")
	public Map<String, Object> verifyPayment(@RequestBody Map<String, Object> payload) {
		Map<String, Object> response = new HashMap<>();
		try {
			String orderId = (String) payload.get("razorpay_order_id");
			String paymentId = (String) payload.get("razorpay_payment_id");
			String signature = (String) payload.get("razorpay_signature");

			// 🔹 Create params as JSONObject
			JSONObject options = new JSONObject();
			options.put("razorpay_order_id", orderId);
			options.put("razorpay_payment_id", paymentId);
			options.put("razorpay_signature", signature);

			// 🔹 Verify signature
			boolean isValid = Utils.verifyPaymentSignature(options, keySecret);

			if (isValid) {
				response.put("status", "success");
				response.put("message", "Payment Verified Successfully");
				response.put("orderId", orderId);
				response.put("paymentId", paymentId);
			} else {
				response.put("status", "failed");
				response.put("message", "Payment Verification Failed");
			}

		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", "Exception: " + e.getMessage());
		}
		return response;
	}
}
