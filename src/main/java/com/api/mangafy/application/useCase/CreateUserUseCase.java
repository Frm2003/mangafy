package com.api.mangafy.application.useCase;

import com.api.mangafy.adapters.dto.CreateUserDto;
import com.api.mangafy.application.ports.PasswordHasher;
import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.Roles;
import com.api.mangafy.domain.User;

import java.util.Set;
import java.util.UUID;

public class CreateUserUseCase {
	private final UserRepository repository;
	private final PasswordHasher passwordHasher;
	
	public CreateUserUseCase(UserRepository repository, PasswordHasher passwordHasher) {
		this.repository = repository;
		this.passwordHasher = passwordHasher;
	}

    public void execute(CreateUserDto dto) {
		User user = new User();
		
		user.setId(UUID.randomUUID());
		user.setEmail(dto.email());
		user.setName(dto.name());
		user.setNickName(dto.nickName());
		user.setPasswd(passwordHasher.hash(dto.passwd()));
		user.setRoles(Set.of(Roles.READER));
		
		this.repository.save(user);
    }
}
