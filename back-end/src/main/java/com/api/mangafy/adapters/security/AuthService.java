package com.api.mangafy.adapters.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.api.mangafy.adapters.dto.LoginDto;

@Service
public class AuthService {
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	public String login(LoginDto dto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.passwd()));

		UserPrincipal user = (UserPrincipal) authentication.getPrincipal();

		return jwtService.generateToken(user);
	}

}
