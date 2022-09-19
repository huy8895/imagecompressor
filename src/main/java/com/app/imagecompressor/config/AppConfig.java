package com.app.imagecompressor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Slf4j
@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
				.setConnectTimeout(Duration.of(30, ChronoUnit.SECONDS))
				.setReadTimeout(Duration.of(30, ChronoUnit.SECONDS))
				.build();
	}


}
