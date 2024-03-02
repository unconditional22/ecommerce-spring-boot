package com.shop.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan(basePackages = {"com.shop.ecommerce.modele", "com.shop.ecommerce.repository", "com.shop.ecommerce.service", "com.shop.ecommerce.controller", "com.shop.ecommerce.config", "com.shop.ecommerce.security", "com.shop.ecommerce.dto"})
public class EcommerceShoppingApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceShoppingApplication.class, args);
	}
	
	@GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "E-Shop Fashion") String name) {
      return String.format("Bienvenue a %s!", name);
	}

}
