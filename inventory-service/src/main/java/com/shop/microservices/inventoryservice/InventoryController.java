package com.shop.microservices.inventoryservice;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shop.microservices.inventoryservice.exception.ItemNotFoundException;

@RestController
public class InventoryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/inventory/all")
	public MappingJacksonValue getAllInventory() {
		List<InventoryEntity> inventoryItems = inventoryRepository.findAll();
		logger.info("Port # - " + env.getProperty("local.server.port"));
		SimpleFilterProvider filters = new SimpleFilterProvider();
		filters.setFailOnUnknownId(false);
		MappingJacksonValue mapping = new MappingJacksonValue(inventoryItems);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/inventory/{id}")
	public MappingJacksonValue getInventoryById(@PathVariable Long id) {
		Optional<InventoryEntity> inventoryEntityOptional = inventoryRepository.findById(id);
		if (!inventoryEntityOptional.isPresent()) {
			throw new ItemNotFoundException("id - " + id);
		}
		logger.info("Port # - " + env.getProperty("local.server.port"));
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Id", "name", "quantity", "price");
		 FilterProvider filters = new SimpleFilterProvider().addFilter("InventoryFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(inventoryEntityOptional);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@PostMapping("/inventory/item")
	public ResponseEntity addInventoryItem(@Valid @RequestBody InventoryEntity item) {
		InventoryEntity inventoryEntity = inventoryRepository.save(item);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId()).toUri();
		logger.info("{}", location);
		return ResponseEntity.created(location).build();		
	}
	
}
