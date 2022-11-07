package com.authentication.service.authentication;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.stream.Stream;


@EnableEurekaClient // Enable eureka client to be discoverable
@EnableFeignClients // feign for intelligent routing of client /service
@SpringBootApplication
public class AuthenticationApplication{



	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
