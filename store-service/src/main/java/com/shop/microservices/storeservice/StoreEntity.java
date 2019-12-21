package com.shop.microservices.storeservice;

import java.math.BigDecimal;

public class StoreEntity {
	private Long id;
	private String name;
	private int quantity;
	private BigDecimal price;
	
	
	public StoreEntity() {
		
	}

	public StoreEntity(Long id, String name, int quantity, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
