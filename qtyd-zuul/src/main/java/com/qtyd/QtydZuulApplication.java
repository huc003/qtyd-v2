package com.qtyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
public class QtydZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(QtydZuulApplication.class, args);
	}
}
