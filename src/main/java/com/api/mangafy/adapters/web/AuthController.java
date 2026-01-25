package com.api.mangafy.adapters.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mangafy.adapters.dto.LoginDto;
import com.api.mangafy.adapters.dto.TokenDto;
import com.api.mangafy.adapters.security.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthService service;

	public AuthController(AuthService service) {
		this.service = service;
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody LoginDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(this.service.login(dto)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
