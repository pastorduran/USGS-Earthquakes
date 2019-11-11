package com.usgs.earthquakes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase para realizar la configuracion de swagger en la aplicacion 
 * @author pastorduran
 * @project USGS-Earthquakes
 * @class SwaggerConfiguration
 * @date nov 11, 2019
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	/**
	 * 
	 * Publish a bean to generate swagger2 endpoints
	 * 
	 * @return a swagger configuration bean
	 * 
	 */

	@Bean
	public Docket sismoApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(sismoApiInfo()).select().paths(sismoPaths())
				.apis(RequestHandlerSelectors.any()).build().useDefaultResponseMessages(false);

	}

	private ApiInfo sismoApiInfo() {
		return new ApiInfoBuilder().title("Servicio de sismos").version("1.0").license("Apache License Version 2.0").build();

	}

	private Predicate<String> sismoPaths() {
		return PathSelectors.regex("/sismos.*");
	}

}
