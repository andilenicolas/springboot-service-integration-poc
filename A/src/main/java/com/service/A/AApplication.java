package com.service.A;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.service.b.clients")
public class AApplication {

	public static void main(String[] args) {
		SpringApplication.run(AApplication.class, args);
	}

}
