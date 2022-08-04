package com.example.ProductManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class ProductManagmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagmentsApplication.class, args);
		//FOR TEST
	}
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		return new  CommonsMultipartResolver();
	}
	
}
