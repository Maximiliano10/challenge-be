package com.api.calculate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.calculate.entity.Logs;
import com.api.calculate.entity.Percentages;
import com.api.calculate.service.ApiCalculateService;
import com.api.calculate.service.PercentagesService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API CORE", description = "This APi serve all functionality for management Calculate and Logs")
@RestController
@RequestMapping("/api")
public class ApiCalculateController {

	@Autowired
	private ApiCalculateService service;	
	
	@Autowired
	private PercentagesService percentagesServiceservice;
	
	final static Logger log = LoggerFactory.getLogger(ApiCalculateController.class);
	
	
	@Operation(description = "Returns the sum of two numbers plus the percentage", summary ="Calculate")
	@GetMapping("/getProcessCalculate/{n1}/{n2}")	
	public ResponseEntity<?> getProcessCalculate(@Parameter(description="Float type parameter") @PathVariable Float n1,@Parameter(description="Float type parameter") @PathVariable Float n2) {				
		Float percentage = null;		
		percentage = service.getProcessCalculate(n1, n2);	
		
		if(percentage == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
				
		return ResponseEntity.ok(percentage);
	}
	
	@Operation(description = "Returns a list of History of all calls to all endpoints", summary ="Calculate")
    @GetMapping("/getAll")
    public ResponseEntity<List<Logs>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
