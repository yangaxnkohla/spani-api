package com.nkohla.yanga.spaniapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableSwagger2
public class SpaniApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaniApiApplication.class, args);
	}

	// http://localhost:port/swagger-ui.html
	@Bean
	public Docket SpaniApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.nkohla.yanga.spaniapi")).build();
	}

}
