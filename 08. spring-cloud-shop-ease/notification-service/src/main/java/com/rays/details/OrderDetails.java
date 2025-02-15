package com.rays.details;

import java.io.Serializable;

public class OrderDetails implements Serializable {

	private int items;
	private String email;

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
