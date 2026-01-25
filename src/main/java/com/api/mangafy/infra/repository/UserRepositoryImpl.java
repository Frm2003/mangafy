package com.api.mangafy.infra.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.User;
import com.api.mangafy.infra.entity.UserEntity;
import com.api.mangafy.infra.mapper.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private final UserEntityRepository jpaRepository;

	public UserRepositoryImpl(UserEntityRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Optional<User> findById(UUID id) {
		return this.jpaRepository.findById(id).map(UserMapper::toDomain);
	}
	
	@Override
	public User save(User user) {
		UserEntity entity = UserMapper.toEntity(user);
		entity = jpaRepository.save(entity);
		return UserMapper.toDomain(entity);
	}
}
