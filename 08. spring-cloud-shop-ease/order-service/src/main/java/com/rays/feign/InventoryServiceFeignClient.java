package com.rays.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service", url = "http://localhost:8081")
public interface InventoryServiceFeignClient {

	@PostMapping("/inventory-service/InventoryCtl/sold")
	public int sold(@RequestParam("qty") int qty);

}