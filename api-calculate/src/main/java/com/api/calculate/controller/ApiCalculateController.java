package com.api.calculate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.service.ApiCalculateService;

@RestController
@RequestMapping("/api/")
public class ApiCalculateController {

	@Autowired
	private ApiCalculateService service;
	
	
	@GetMapping("getProcessCalculate/{n1}/{n2}")
	public ResponseEntity<?> getProcessCalculate(@PathVariable Float n1, @PathVariable Float n2) {
	
		return ResponseEntity.ok(service.getProcessCalculate(n1, n2));
	}
}
