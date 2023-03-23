package com.api.calculate.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.api.calculate.dao.LogsDao;
import com.api.calculate.entity.Logs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

@Component
public class EndpointLoggingFilter extends OncePerRequestFilter{

	private static final Logger LOGGER = LogManager.getLogger(EndpointLoggingFilter.class);

	@Autowired
	LogsDao dao;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	  try {
		  
		filterChain.doFilter(request, response);
		  
		// Agregar registro a la base de datos
		Date fecha = new Date();
		String method = request.getMethod();
		String path = request.getRequestURI();
		Integer statusCode = response.getStatus();
		String statusDescription = HttpStatus.valueOf(statusCode).getReasonPhrase();
		
		Logs logs = new Logs();
		logs.setEndpoint(path);
		logs.setResponseCode(statusCode);
		logs.setResponseDescription(statusDescription);
		logs.setDate(fecha);
		
		dao.save(logs);
        
	  } catch (Exception ex) {
          LOGGER.error("Error in EndpointLoggingFilter", ex);
      }
	  
	}
	
}
