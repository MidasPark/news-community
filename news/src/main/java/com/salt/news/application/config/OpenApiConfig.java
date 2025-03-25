//package com.salt.news.application.config;
//
//import io.swagger.v3.oas.models.ExternalDocumentation;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springdoc.core.annotations.GroupedOpenApi;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class OpenApiConfig {
//
//    // 그룹별 API 설정
//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .group("news-admin")  // 그룹명 변경
//                .pathsToMatch("/admin/**")
//                //.addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class)) // 주석 처리
//                .build();
//    }
//
//    // 기본 OpenAPI 설정
//    @Bean
//    public OpenAPI springNewsOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Salt News API")
//                        .description("뉴스 커뮤니티 애플리케이션 API 문서")
//                        .version("v1.0.0")
//                        .license(new License()
//                                .name("Apache 2.0")
//                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("Salt News Wiki")
//                        .url("https://github.com/salt-news/docs"));
//    }
//}
