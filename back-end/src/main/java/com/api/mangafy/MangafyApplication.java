package com.api.mangafy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class MangafyApplication {

	static void main(String[] args) {
		SpringApplication.run(MangafyApplication.class, args);
	}

}
