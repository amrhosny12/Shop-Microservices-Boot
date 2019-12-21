package com.shop.microservices.configservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config-service")
public class Configuration {
	private String URI;
	private String Region;
	
	public String getURI() {
		return URI;
	}
	public String getRegion() {
		return Region;
	}
	public void setURI(String uri) {
		URI = uri;
	}
	public void setRegion(String region) {
		Region = region;
	}

}
