package com.qtyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/5/14
 * @Description: 类描述
 **/
@Configuration
public class MyConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
