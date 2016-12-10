package com.bluoh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableMongoAuditing
@EnableSwagger2
public class BluohApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluohApiApplication.class, args);
	}

	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.pathMapping("/");
	}

	private ApiInfo apiInfo() {
        return new ApiInfo(
                "Karbide REST API",
				"API documentation is availabe here.",
				"API 1.0",
				"Terms of service",
				"developers@karbide.com",
				"License of API",
				"API license URL");
	}
}
