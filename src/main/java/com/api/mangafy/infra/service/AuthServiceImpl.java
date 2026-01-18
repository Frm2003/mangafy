package com.api.mangafy.infra.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.api.mangafy.adapters.dto.LoginDto;
import com.api.mangafy.application.AuthService;
import com.api.mangafy.infra.entity.UserEntity;

@Service
public class AuthServiceImpl implements AuthService {
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@Override
	public String login(LoginDto dto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.passwd()));

		UserEntity user = (UserEntity) authentication.getPrincipal();

		return jwtService.generateToken(user);
	}

}
