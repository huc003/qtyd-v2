package com.qtyd.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/23
 * @Description: 负载均衡
 **/
//@Configuration
//@ExcludeFromComponentScan
public class RibbonConfiguration {
    /**
     * 设置负载均衡的规则为随机
     * */
//    @Bean
//    public IRule ribbonRule() {
//        return new RandomRule();
//    }
}
