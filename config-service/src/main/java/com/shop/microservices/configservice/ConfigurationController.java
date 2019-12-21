package com.shop.microservices.configservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.microservices.configservice.entity.ConfigEntity;

@RestController
public class ConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/config")
//	@HystrixCommand(fallbackMethod="fallbackRetrieveConfig")
	public ConfigEntity getQAConfigurations() {
		return new ConfigEntity(configuration.getURI(), configuration.getRegion());
	}

}
