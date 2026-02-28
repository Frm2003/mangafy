package com.api.mangafy.application.useCase;

import java.util.List;
import java.util.UUID;

import com.api.mangafy.adapters.dto.CreatePublicationDto;
import com.api.mangafy.application.ports.GenreRepository;
import com.api.mangafy.application.ports.PublicationRepository;
import com.api.mangafy.application.ports.UserRepository;
import com.api.mangafy.domain.Genre;
import com.api.mangafy.domain.Publication;
import com.api.mangafy.domain.User;

public class CreatePublicationUseCase {
	private final PublicationRepository publicationrepository;
	private final UserRepository userRepository;
	private final GenreRepository genderRepository;

	public CreatePublicationUseCase(PublicationRepository publicationrepository, UserRepository userRepository, GenreRepository genderRepository) {
		this.publicationrepository = publicationrepository;
		this.userRepository = userRepository;
		this.genderRepository = genderRepository;
	}

	public void execute(UUID authorId, CreatePublicationDto dto) {
		User user = this.userRepository.findById(authorId)
	    		.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		List<Genre> genderList = this.genderRepository.findAllById(dto.genderIds());
		
		Publication publication = new Publication();
		
		publication.setId(UUID.randomUUID());
		publication.setUser(user);
		publication.setTitle(dto.title());
		publication.setSynopsis(dto.synopsis());
		publication.setLaunchDate(dto.launchDate());
		publication.setISBN10(dto.ISBN10());
		publication.setISBN13(dto.ISBN13());
		publication.setCoverStorageUrl(dto.coverStorageUrl());
		publication.setGenres(genderList);
		
		this.publicationrepository.create(publication);
	}
}
