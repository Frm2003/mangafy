package com.api.mangafy.adapters.web;

import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mangafy.adapters.dto.LoginDto;
import com.api.mangafy.adapters.security.AuthService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthService service;

	public AuthController(AuthService service) {
		this.service = service;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody LoginDto dto, HttpServletResponse response) {
		try {
			 String token = service.login(dto);
			 
			 ResponseCookie cookie = ResponseCookie.from("jwt", token)
		                .httpOnly(true)
		                .secure(false)
		                .path("/")
		                .sameSite("Lax")
		                .maxAge(Duration.ofHours(1))
		                .build();
			 
			 response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
			 
			 return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
