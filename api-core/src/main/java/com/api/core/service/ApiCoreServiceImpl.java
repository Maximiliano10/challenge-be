package com.api.core.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiCoreServiceImpl implements ApiCoreService {

	@Autowired
	RestTemplate template;
	
	@Override
	public Float getCalculate(Float n1, Float n2) {
		
		String url= "http://localhost:8002/api/getProcessCalculate/{n1}/{n2}";
		
		String result = template.getForObject(url, String.class, n1, n2);
		
		return Float.parseFloat(result);
	}

}
