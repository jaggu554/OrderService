package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfig {

	@Bean
	BasicAuthRequestInterceptor basicAuthenticationInterceptor() {
		return new BasicAuthRequestInterceptor("userName", "password");
	}
}
