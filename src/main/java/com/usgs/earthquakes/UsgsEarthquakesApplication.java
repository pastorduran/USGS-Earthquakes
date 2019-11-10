package com.usgs.earthquakes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UsgsEarthquakesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsgsEarthquakesApplication.class, args);
	}
		
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
