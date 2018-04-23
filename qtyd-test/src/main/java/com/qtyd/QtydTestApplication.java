package com.qtyd;

import com.qtyd.config.ExcludeFromComponentScan;
import com.qtyd.config.RibbonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 胡成
 * @Date:   2018/4/20 14:19
 * @Description: 测试文件类
**/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//@RibbonClient(name="activity-provider-service",configuration = RibbonConfiguration.class)
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value=ExcludeFromComponentScan.class)})
public class QtydTestApplication {

//	@Autowired
//	private RestTemplateBuilder builder;

	public static void main(String[] args) {
		SpringApplication.run(QtydTestApplication.class, args);
	}

//	@Bean
//	@LoadBalanced//客户端负载均衡
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(){
//		return builder.build();
//	}
}
