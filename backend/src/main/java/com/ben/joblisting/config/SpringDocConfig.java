package com.ben.joblisting.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title("Job Listing API").version("1.0.0"));
	}

	@Bean
	public GroupedOpenApi httpApi() {
		return GroupedOpenApi.builder()
				.group("http")
				.pathsToMatch("/**")
				.build();
	}

}