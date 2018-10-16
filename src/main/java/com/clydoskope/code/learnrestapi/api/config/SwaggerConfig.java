package com.clydoskope.code.learnrestapi.api.config;

import com.clydoskope.code.learnrestapi.api.v1.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@ComponentScan(basePackageClasses = {
        RestApiController.class
})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.clydoskope.code"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Learn Rest Api")
                .description("Learning Rest Api with Swagger")
                .termsOfServiceUrl("http://localhost:8080/")
                .contact(new Contact("Adarsh Kumar", "https://gitlab.com/clydoskope", "adarshkumar9820@gmail.com"))
                .version("1.0")
                .build();
    }

}