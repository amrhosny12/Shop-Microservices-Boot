package com.shop.microservices.configservice.entity;

public class ConfigEntity {
	private String URI;
	private String Region;
	
	public ConfigEntity() {
		
	}

	public ConfigEntity(String uri, String region) {
		super();
		URI = uri;
		Region = region;
	}

	public String getURI() {
		return URI;
	}

	public String getRegion() {
		return Region;
	}

	
	
	
}
