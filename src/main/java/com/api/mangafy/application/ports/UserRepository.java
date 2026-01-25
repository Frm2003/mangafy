package com.api.mangafy.application.ports;

import java.util.Optional;
import java.util.UUID;

import com.api.mangafy.domain.User;

public interface UserRepository {
	Optional<User> findById(UUID id);
	User save(User user);
}
