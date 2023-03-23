package com.gateway.config;


import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;



@Component
public class GlobalPreFiltering implements GlobalFilter{
	
	private static final Logger LOGGER = LogManager.getLogger(GlobalPreFiltering.class);
	
    private static final int MAX_ATTEMPTS_PER_MINUTE = 3;
    private static final int MAX_FAILED_ATTEMPTS = 3; // Nueva variable para limitar la cantidad de intentos fallidos

    private Queue<Long> requestTimes = new LinkedList<>();
    private int failedAttempts = 1; // Nueva variable para llevar el registro de los intentos fallidos

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       
    	LOGGER.info("Global prefilter executed");    	
    	ServerHttpResponse response = exchange.getResponse();
        var originalStatusCode = response.getStatusCode();
        int rawStatusCode = response.getStatusCode().value();
    	
        
        long currentTime = System.currentTimeMillis();
        requestTimes.add(currentTime);

        // Remove request times that are older than one minute
        while (!requestTimes.isEmpty() && currentTime - requestTimes.peek() > 60000) {
            requestTimes.poll();
        }

        LOGGER.info("Try Number: " + requestTimes.size());
        if (requestTimes.size() > MAX_ATTEMPTS_PER_MINUTE) {
            LOGGER.error("Maximum number of attempts per minute exceeded");
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
    	
        failedAttempts = (originalStatusCode == HttpStatus.OK) ? 1:  failedAttempts; 
        
        if (originalStatusCode != HttpStatus.OK) { // Si la respuesta es un error

			failedAttempts++; // Incrementar el contador de intentos fallidos
			if (failedAttempts >= MAX_FAILED_ATTEMPTS) { // Si se han superado los tres intentos fallidos
				LOGGER.error("Maximum number of failed attempts exceeded");
				exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
				return exchange.getResponse().setComplete();
			}
		} else { // Si la respuesta es exitosa
			failedAttempts = 0; // Reiniciar el contador de intentos fallidos
		}
        
        return chain.filter(exchange);
    }    
	
}
