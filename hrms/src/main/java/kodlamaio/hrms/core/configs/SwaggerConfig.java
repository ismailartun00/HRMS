package kodlamaio.hrms.core.configs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms"))
	      .build()
	      .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "HRMS API Reference", 
	      null, null, null, 
	      new Contact("Ismail Artun", "https://ismailartun00.github.io/", "ismailartun00@gmail.com"), 
	      null, null, Collections.emptyList());
	}
}
