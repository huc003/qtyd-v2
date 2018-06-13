package com.qtyd.config;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.DefaultRateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/5/29
 * @Description: 类描述
 **/
@Configuration
public class RateLimitConfig {
//    @Bean
//    public RateLimitKeyGenerator rateLimitKeyGenerator(final RateLimitProperties properties){
//        return new DefaultRateLimitKeyGenerator(properties){
//            @Override
//            public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {
//                System.out.println("=========="+request.getParameter("name"));
//                return super.key(request, route, policy)+":"+request.getParameter("name");
//            }
//        };
//    }
}
