package com.api.mangafy.adapters.web;

import com.api.mangafy.adapters.dto.BecomeAuthorDto;
import com.api.mangafy.adapters.dto.CreateUserDto;
import com.api.mangafy.application.useCase.BecomeAuthorUseCase;
import com.api.mangafy.application.useCase.CreateUserUseCase;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	private final CreateUserUseCase createUserUseCase;
	private final BecomeAuthorUseCase becomeAuthorUseCase;

	public UserController(CreateUserUseCase createUserUseCase, BecomeAuthorUseCase becomeAuthorUseCase) {
		this.createUserUseCase = createUserUseCase;
		this.becomeAuthorUseCase = becomeAuthorUseCase;
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CreateUserDto dto) {
		try {
			this.createUserUseCase.execute(dto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PreAuthorize("hasRole('READER')")
	@PutMapping("/author")
	public ResponseEntity<Void> becomeAuthor(@AuthenticationPrincipal Jwt jwt, @RequestBody BecomeAuthorDto dto) {
		try {
			this.becomeAuthorUseCase.execute(UUID.fromString(jwt.getSubject()), dto);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
