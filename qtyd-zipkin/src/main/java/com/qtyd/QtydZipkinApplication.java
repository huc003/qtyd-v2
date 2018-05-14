package com.qtyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;
//import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer
@EnableZipkinServer
public class QtydZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(QtydZipkinApplication.class, args);
	}
}
