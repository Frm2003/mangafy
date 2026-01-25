package com.api.mangafy.infra.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.mangafy.application.ports.PasswordHasher;

@Service
public class PasswordHasherImpl implements PasswordHasher {
	private final PasswordEncoder encoder;
	
	public PasswordHasherImpl(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public String hash(String rawPassword) {
		return this.encoder.encode(rawPassword);
	}
	
}
