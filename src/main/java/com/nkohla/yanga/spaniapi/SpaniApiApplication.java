package com.nkohla.yanga.spaniapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2
public class SpaniApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaniApiApplication.class, args);
	}

	// http://localhost:port/swagger-ui.html
	//	@Bean
	//	public Docket SpaniApi() {
	//		return new Docket(DocumentationType.SWAGGER_2).select()
	//				.apis(RequestHandlerSelectors.basePackage("com.nkohla.yanga.spaniapi")).build();
	//	}
}
