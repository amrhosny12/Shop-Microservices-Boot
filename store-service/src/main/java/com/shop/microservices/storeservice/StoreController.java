package com.shop.microservices.storeservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StoreController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InventoryServiceProxy proxy;

	@GetMapping("/store/get/{id}")
	public StoreEntity getStoreItem(@PathVariable Long id) {
		Map<String, Long> uriVariables = new HashMap();
		uriVariables.put("id", id);
		ResponseEntity<StoreEntity> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/inventory/{id}", StoreEntity.class, uriVariables);
		StoreEntity response = responseEntity.getBody();
		logger.info("{}", response);
		return new StoreEntity(id, response.getName(), response.getQuantity(), response.getPrice());
	}
	
	@GetMapping("/store/feign/get/{id}")
	public StoreEntity getFeignStoreItem(@PathVariable Long id) {
		StoreEntity response = proxy.getInventoryById(id);
		logger.info("{}", response);
		return new StoreEntity(id, response.getName(), response.getQuantity(), response.getPrice());
	}

}
