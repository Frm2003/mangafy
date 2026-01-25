package com.api.mangafy.application.useCase;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.api.mangafy.adapters.dto.BecomeAuthorDto;
import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.AuthorProfile;
import com.api.mangafy.domain.Roles;
import com.api.mangafy.domain.User;

public class BecomeAuthorUseCase {
	private final UserRepository repository;

	public BecomeAuthorUseCase(UserRepository repository) {
		this.repository = repository;
	}
	
	public void execute(UUID id, BecomeAuthorDto dto) {
	    User user = this.repository.findById(id)
	    		.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
	    
	    AuthorProfile authorProfile = new AuthorProfile(dto.cpf(), dto.cnpj());
	    
	    Set<Roles> roles = new HashSet<>(user.getRoles());
	    roles.add(Roles.AUTHOR);
	    
	    user.setRoles(roles);
	    user.setAuthorProfile(authorProfile);
	    
	    repository.save(user);
	}

}
