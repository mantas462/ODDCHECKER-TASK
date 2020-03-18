package com.oddchecker.oddsrestapi.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Tag;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() { 
    	 return new Docket(DocumentationType.SWAGGER_2)  
    	          .select()                                  
    	          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))              
    	          .paths(PathSelectors.any())                          
    	          .build()
    	          .apiInfo(apiInfo()).useDefaultResponseMessages(false);
    	    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
          "Oddschecker Odds API",
          "This is a schema that should be conformed to for the Oddschecker Odds API unattended task.",
          "1.0.0",
          null,
          null,
          null,
          null);
        return apiInfo;
    }
 
	
}
