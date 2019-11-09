package com.usgs.earthquakes.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Setter
@Getter
public class ApplicationConfig {
	
	private UsgsProperties usgsProperties;
	
	private UsgsEndPoint usgsEndPoint;
	
	@ToString
	@Setter
	@Getter
	public static class UsgsProperties{
		private String schema;
		private String host;
		private String port;
		private String path;
	}
	
	@ToString
	@Setter
	@Getter
	public static class UsgsEndPoint{
		private String earthQuakesBetweenDate;
		private String earthQuakesCount;
	}

}
