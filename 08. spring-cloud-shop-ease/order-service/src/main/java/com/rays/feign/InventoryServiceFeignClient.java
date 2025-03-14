package com.rays.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The {@code InventoryServiceFeignClient} interface defines a Feign client for communicating
 * with the Inventory Service. It provides a method to mark items as sold.
 * 
 * <p>
 * Annotations used:
 * <ul>
 *   <li>{@link FeignClient} - Specifies this interface as a Feign client for the Inventory Service.</li>
 *   <li>{@link PostMapping} - Defines an HTTP POST request mapping.</li>
 *   <li>{@link RequestParam} - Binds request parameters to method parameters.</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2025-03-15
 */
@FeignClient(name = "inventory-service", url = "http://localhost:8081")
public interface InventoryServiceFeignClient {

    /**
     * Calls the Inventory Service to mark items as sold.
     *
     * @param qty The quantity of items to be marked as sold.
     * @return The updated inventory count after the operation.
     */
    @PostMapping("/inventory-service/InventoryCtl/sold")
    int sold(@RequestParam("qty") int qty);
}
