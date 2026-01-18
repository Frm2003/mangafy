package com.api.mangafy.infra.service;

import com.api.mangafy.adapters.dto.UserDto;
import com.api.mangafy.application.UserService;
import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.Roles;
import com.api.mangafy.domain.User;

import java.util.Set;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository repository;
	private final PasswordEncoder encoder;
	
  
	public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
		super();
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
    public void create(UserDto dto) {
		User user = new User();
		
		user.setId(UUID.randomUUID());
		user.setEmail(dto.email());
		user.setName(dto.name());
		user.setNickName(dto.nickName());
		user.setPasswd(encoder.encode(dto.passwd()));
		user.setRoles(Set.of(Roles.READER));
		
		this.repository.save(user);
    }

}
