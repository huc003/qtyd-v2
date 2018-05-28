package com.qtyd;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author: 胡成
 * @Date:   2018/4/20 14:09
 * @Description: 活动提供者服务启动入口
**/
@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan(basePackages={"com.qtyd.mapper"}, sqlSessionFactoryRef="sqlSessionFactory")
public class ActivityProviderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityProviderServiceApplication.class, args);
	}

}
