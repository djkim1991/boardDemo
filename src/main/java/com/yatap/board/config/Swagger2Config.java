package com.yatap.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Profile({"dev", "beta"})
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())                                                                     // API 기본 정보
            .useDefaultResponseMessages(false)                                                      // 디폴트 응답 코드 제거(true: 201, 401, 403, 404)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.yatap.board.controller"))                // package 설정
            .paths(PathSelectors.any())                                                             // URL 설정
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("게시판 API")
            .version("v1")
            .description("게시판 API 입니다.")
            .license("dongju")
            .licenseUrl("https://dororongju.tistory.com")
            .build();
    }
}
