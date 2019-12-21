package com.shop.microservices.shopeurekanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopEurekaNamingServerApplication.class, args);
	}

}
