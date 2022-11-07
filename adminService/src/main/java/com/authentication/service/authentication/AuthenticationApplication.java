package com.authentication.service.authentication;

import com.authentication.service.authentication.model.User;
import com.authentication.service.authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.stream.Stream;

@EnableEurekaClient
@SpringBootApplication
public class AuthenticationApplication implements CommandLineRunner {

	private final UserRepository repository;

	public AuthenticationApplication(UserRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Movie App
		//
		//
		//=> Movie Server => Eureka Server
		//
		//
		//// Eureka Clients
		//
		//=> Authentication Service => Signup, Login  => h2 Database => cloud.properties
		//
		//=> Movie Service =>  Movie Crud => Add, Finding Movies => MongoDB  => cloud.properties

		// H2 Console: localhost:8080/h2-console

		// users Table: localhost:8080/users
		repository.save(new User("Arjun","Arjun@gmail.com","12345678"));
		repository.save(new User("Manish","Manish@gmail.com","23456789"));
		repository.save(new User("Pratham","Pratham@gmail.com","34567890"));

	}
}
