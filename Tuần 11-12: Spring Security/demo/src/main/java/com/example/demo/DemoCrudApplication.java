package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoCrudApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password[] = {"123admin", "123sadmin", "123tardmin"};
		for (int i = 0; i < password.length; i++)
			System.out.println(passwordEncoder.encode(password[i]));

	}
}
