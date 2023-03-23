package com.api.externa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiExternaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiExternaApplication.class, args);
	}

}
