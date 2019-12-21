package com.shop.microservices.storeservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="inventory-service")
//@FeignClient(name="shop-zuul-api-gateway-server")
@RibbonClient(name="inventory-service")
public interface InventoryServiceProxy {
	
	@GetMapping("/inventory/{id}")
	public StoreEntity getInventoryById(@PathVariable("id") Long id);
	
}

