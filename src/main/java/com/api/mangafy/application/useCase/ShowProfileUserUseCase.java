package com.api.mangafy.application.useCase;

import java.util.UUID;

import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.User;

public class ShowProfileUserUseCase {
	private final UserRepository repository;

	public ShowProfileUserUseCase(UserRepository repository) {
		this.repository = repository;
	}

	public User execute(UUID id) {
		return this.repository.findById(id).orElseThrow(() -> new RuntimeException());
	}
}
