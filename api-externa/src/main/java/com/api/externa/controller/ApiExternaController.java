package com.api.externa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiExternaController {
	
    @GetMapping("getPercentage")
    public String getPercentage() throws Exception {
    	return "15";
    }

}
