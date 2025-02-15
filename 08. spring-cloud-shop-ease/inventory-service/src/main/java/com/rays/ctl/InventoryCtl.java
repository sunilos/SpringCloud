package com.rays.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "InventoryCtl")
public class InventoryCtl {

	@Value(value = "100")
	int stock = 0;

	@PostMapping("sold")
	public int sold(@RequestParam int qty) {
		stock -= qty;
		return stock;
	}
}
