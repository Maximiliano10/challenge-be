package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory.RetryConfig;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;

import reactor.core.publisher.Mono;

import java.time.Duration;

@Configuration
public class SpringCloudConfig {

	final static Logger log = LoggerFactory.getLogger(SpringCloudConfig.class);
	
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    	
	  
    	log.info("Comienza gatewayRoutes ");
	    RetryConfig config = new RetryConfig()
		        .setRetries(3)
		        .setStatuses(HttpStatus.BAD_REQUEST)
		        .setMethods(HttpMethod.GET, HttpMethod.POST);
		  
	    log.info("config.getRetries " + config.getRetries());
	    
		    return builder.routes()
		            .route("api-calculate", r -> r.path("/api/**")
		                    .filters(f -> f.retry(c -> c.setRetries(3))
		                            .filter(new RetryGatewayFilterFactory().apply(config)))
		                    .uri("lb://api-calculate"))
		            .build();
    	
    }
}
