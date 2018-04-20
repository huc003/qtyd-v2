package com.qtyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/20
 * @Description: 类描述
 **/
@Configuration//声明该类为配置类
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createFundsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qtyd.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API测试调用地址")
                .description("如有问题请自行解决")
                .termsOfServiceUrl("https://www.qtyd.com")
                .contact("hucheng")
                .version("1.0")
                .build();
    }
}
