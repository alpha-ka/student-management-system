package com.alpha.sms.config;

import org.springframework.boot.actuate.trace.http.HttpTraceEndpoint;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpTraceConfig {

	@Bean
	public HttpTraceRepository httpTrace() {
		
		
		return new InMemoryHttpTraceRepository();
		
		
	} 
	
	
}
