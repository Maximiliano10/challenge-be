package com.api.calculate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.calculate.service.ApiCalculateServiceImpl;

@SpringBootTest
class ApiCalculateApplicationTests {

    private static final Float N1 = 10.0f;
    private static final Float N2 = 5.0f;

    @InjectMocks
    private ApiCalculateServiceImpl service;
    

    
	//@Test
	public void testGetCalculate() {

	  // Ejecuta el método que deseas probar
	  Float result = service.getProcessCalculate(N1, N2);
	  
	  assertNotNull(result);
	}
}
