package com.softcaribbean.challenge.elverarroyave.configuration;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("msc-product")
                .apiInfo(apiInfo())
                .select()
                .paths((Predicate<String>) regex("/api/v1.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API REST services")
                .description("Especificacion de REST API services")
                .termsOfServiceUrl("Terminos de Servicio")
                .license("REST-softCaribean")
                .version("1.0")
                .build();
    }
}
