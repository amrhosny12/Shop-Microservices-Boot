package com.shop.microservices.inventoryservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonFilter("InventoryFilter")
@ApiModel(description="All Inventory Details")
@Entity
public class InventoryEntity {

	@Id
	@GeneratedValue
	private Long Id;
	
	@Size(min=2, message="Name should be at least 2 characters")
	@ApiModelProperty(notes="Name should be at least 2 characters")
	private String name;
	
	private int quantity;
	
	private BigDecimal price;
	
	public InventoryEntity() {
		
	}

	public InventoryEntity(String name, int quantity, BigDecimal price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
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

	public Long getId() {
		return Id;
	}
	
}
