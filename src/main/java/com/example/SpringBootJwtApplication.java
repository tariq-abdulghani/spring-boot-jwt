package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	
	
	@GetMapping("/")
	public String getIndex() {
		return "Welcome !!";
	}
	
	@PostMapping("/login")
	public String login() {
		return "";
	}
	
	@GetMapping("/users")
	public String getUsers() {
		return "users Page";
	}
}
