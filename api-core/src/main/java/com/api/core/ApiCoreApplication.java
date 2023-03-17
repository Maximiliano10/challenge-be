package com.api.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCoreApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
