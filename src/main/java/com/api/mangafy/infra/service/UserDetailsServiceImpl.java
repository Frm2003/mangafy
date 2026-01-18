package com.api.mangafy.infra.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.mangafy.infra.repository.UserEntityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserEntityRepository repository;

	public UserDetailsServiceImpl(UserEntityRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
	}

}
