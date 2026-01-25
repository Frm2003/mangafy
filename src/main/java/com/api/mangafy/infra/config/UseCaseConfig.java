package com.api.mangafy.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.mangafy.application.ports.PasswordHasher;
import com.api.mangafy.application.ports.PublicationRepository;
import com.api.mangafy.application.ports.StorageService;
import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.application.useCase.BecomeAuthorUseCase;
import com.api.mangafy.application.useCase.CreatePublicationUseCase;
import com.api.mangafy.application.useCase.CreateUserUseCase;
import com.api.mangafy.application.useCase.UploadImageUseCase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	CreateUserUseCase createUserUseCase(UserRepository userRepository, PasswordHasher passwordHasher) {
		return new CreateUserUseCase(userRepository, passwordHasher);
	}
	
	@Bean
	BecomeAuthorUseCase becomeAuthorUseCase(UserRepository userRepository) {
		return new BecomeAuthorUseCase(userRepository);
	}
	
	@Bean
	CreatePublicationUseCase createPublicationUseCase(PublicationRepository publicationRepository, UserRepository userRepository) {
		return new CreatePublicationUseCase(publicationRepository, userRepository);
	}
	
	@Bean
	UploadImageUseCase uploadImageUseCase(StorageService service) {
		return new UploadImageUseCase(service);
	}

}
