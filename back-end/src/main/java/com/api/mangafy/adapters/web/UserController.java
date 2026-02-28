package com.api.mangafy.adapters.web;

import com.api.mangafy.adapters.dto.BecomeAuthorDto;
import com.api.mangafy.adapters.dto.CreateUserDto;
import com.api.mangafy.adapters.dto.PrivateUserDto;
import com.api.mangafy.adapters.security.UserPrincipal;
import com.api.mangafy.application.useCase.BecomeAuthorUseCase;
import com.api.mangafy.application.useCase.CreateUserUseCase;
import com.api.mangafy.application.useCase.ShowProfileUserUseCase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
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
	private final ShowProfileUserUseCase showProfileUserUseCase;

	public UserController(CreateUserUseCase createUserUseCase, BecomeAuthorUseCase becomeAuthorUseCase,
			ShowProfileUserUseCase showProfileUserUseCase) {
		this.createUserUseCase = createUserUseCase;
		this.becomeAuthorUseCase = becomeAuthorUseCase;
		this.showProfileUserUseCase = showProfileUserUseCase;
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/profile")
	public ResponseEntity<PrivateUserDto> becomeAuthor(@AuthenticationPrincipal UserPrincipal user) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.showProfileUserUseCase.execute(user.getId()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
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
	public ResponseEntity<Void> becomeAuthor(@AuthenticationPrincipal UserPrincipal user, @RequestBody BecomeAuthorDto dto) {
		try {
			this.becomeAuthorUseCase.execute(user.getId(), dto);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
