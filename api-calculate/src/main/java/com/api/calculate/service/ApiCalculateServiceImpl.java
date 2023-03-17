package com.api.calculate.service;

import org.springframework.stereotype.Service;

@Service
public class ApiCalculateServiceImpl implements ApiCalculateService {

	
	@Override
	public Float getProcessCalculate(Float n1, Float n2) {
		Float porcent = (float) 10;
		Float result;
		
		result = (n1 + n2) + ( (n1 + n2) * porcent/100);
		
		return result;
	}

}
