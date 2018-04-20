package com.qtyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @Author: 胡成
 * @Date:   2018/4/20 14:06
 * @Description: 注册中心
**/
@SpringBootApplication
@EnableEurekaServer
public class QtydServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(QtydServerApplication.class, args);
	}
}
