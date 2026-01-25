package com.api.mangafy.adapters.web;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mangafy.adapters.dto.CreatePublicationDto;
import com.api.mangafy.application.useCase.CreatePublicationUseCase;

@RestController
@RequestMapping("/publications")
public class PublicationController {
	private final CreatePublicationUseCase createPublicationUseCase;
	
	public PublicationController(CreatePublicationUseCase createPublicationUseCase) {
		this.createPublicationUseCase = createPublicationUseCase;
	}

	@PreAuthorize("hasRole('AUTHOR')")
	@PostMapping
	public ResponseEntity<Void> create(@AuthenticationPrincipal Jwt jwt, @RequestBody CreatePublicationDto dto) {
		try {
			this.createPublicationUseCase.execute(UUID.fromString(jwt.getSubject()), dto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
