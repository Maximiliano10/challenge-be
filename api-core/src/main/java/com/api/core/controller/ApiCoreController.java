package com.api.core.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.core.service.ApiCoreService;


@RestController
@RequestMapping("/api/")
public class ApiCoreController {

	@Autowired
	private ApiCoreService service;
	
	@GetMapping("getCalculate/{n1}/{n2}")
	public ResponseEntity<?> getCalculate(@PathVariable Float n1, @PathVariable Float n2) {
	
		return ResponseEntity.ok(service.getCalculate(n1, n2));
	}
}
