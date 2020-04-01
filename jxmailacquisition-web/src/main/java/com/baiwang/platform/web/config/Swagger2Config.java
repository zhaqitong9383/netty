package com.baiwang.platform.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: shiqiang
 * @Date: 2018/11/26 16:50
 * @Description:
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.baiwang.platform.web.controller")
@Profile({"default", "dev", "test"})
public class Swagger2Config {

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("jxmailacquisition")
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("API接口文档")
        .description("RESTful风格接口")
        .version("1.0")
        .contact(new Contact("Generated@百望", "http://confluence.51baiwang.com", ""))
        .description("api接口文档")
        .build();
  }
}
