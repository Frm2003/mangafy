package com.api.mangafy.application.useCase;

import java.util.UUID;

import com.api.mangafy.adapters.dto.PrivateUserDto;
import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.User;

public class ShowProfileUserUseCase {
	private final UserRepository repository;

	public ShowProfileUserUseCase(UserRepository repository) {
		this.repository = repository;
	}

	public PrivateUserDto execute(UUID id) {
		User user = this.repository.findById(id).orElseThrow(() -> new RuntimeException());
		return new PrivateUserDto(user);
	}
}
