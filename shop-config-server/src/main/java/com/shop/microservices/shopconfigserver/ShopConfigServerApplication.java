package com.shop.microservices.shopconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ShopConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopConfigServerApplication.class, args);
	}

}
