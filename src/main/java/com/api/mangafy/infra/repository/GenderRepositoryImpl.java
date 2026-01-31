package com.api.mangafy.infra.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.mangafy.application.ports.GenreRepository;
import com.api.mangafy.domain.Genre;
import com.api.mangafy.infra.mapper.GenreMapper;

@Repository
public class GenderRepositoryImpl implements GenreRepository {
	private final GenreEntityRepository jpaRepository;

	public GenderRepositoryImpl(GenreEntityRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public List<Genre> findAllById(List<Integer> ids) {
		return this.jpaRepository.findAllById(ids).stream().map(GenreMapper::toDomain).toList();
	}

}
