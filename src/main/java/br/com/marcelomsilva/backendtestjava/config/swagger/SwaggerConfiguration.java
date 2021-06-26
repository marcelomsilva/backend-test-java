package br.com.marcelomsilva.backendtestjava.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;


@Configuration


public class SwaggerConfiguration {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FCamara API REST")
                .description("<h4>API Rest Desafio</h4>")
                .version("1.1.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.marcelomsilva.backendtestjava"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalOperationParameters(
                        Arrays.asList(
                                new ParameterBuilder()
                                        .name("Authorization")
                                        .description("JWT Token")
                                        .modelRef(new ModelRef("string"))
                                        .parameterType("header")
                                        .required(false)
                                        .build()))
                .apiInfo(apiInfo());
    }

}
