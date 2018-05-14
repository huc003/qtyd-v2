package com.qtyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author: 胡成
 * @Date:   2018/4/20 14:19
 * @Description: 测试文件类
**/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class QtydTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(QtydTestApplication.class, args);
	}
}
