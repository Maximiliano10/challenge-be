
package com.gateway.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalPostFiltering {
	
	private static final Logger LOGGER = LogManager.getLogger(GlobalPreFiltering.class);
    
   @Bean
  public GlobalFilter postGlobalFilter() {
      return (exchange, chain) -> {
          return chain.filter(exchange)
            .then(Mono.fromRunnable(() -> {
            	LOGGER.info("Global Post Filter executed");
            }));
      };
  }

}
