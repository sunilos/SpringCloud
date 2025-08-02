package com.sunilos.inventory.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling inventory-related operations.
 * This RESTful API allows users to manage stock by updating inventory when items are sold.
 */
@RestController
@RequestMapping(value = {"ctl/inventory"})
public class InventoryCtl {

    /**
     * Represents the available stock quantity. 
     * Default stock is set to 100.
     */
    @Value(value = "100")
    private int stock;

    /**
     * Deducts the specified quantity from the stock when an item is sold.
     *
     * @param qty The quantity of items sold.
     * @return The updated stock after the sale.
     */
    @PostMapping("sold")
    public int sold(@RequestParam int qty) {
        stock -= qty;
        return stock;
    }

    /**
     * Health check endpoint to verify if the service is running.
     *
     * @return A status message confirming the service is active.
     */
    @GetMapping
    public String get() {
        return this.getClass().getName() + ": I am fit and fine, and I am running.";
    }

    /**
	 * Check the stock
	 * 
	 * @return
	 */
	@GetMapping("/check")
	public int checkStock() {
		return stock;
	}
}
