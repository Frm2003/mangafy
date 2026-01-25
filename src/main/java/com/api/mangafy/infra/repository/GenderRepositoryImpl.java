package com.api.mangafy.infra.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.mangafy.application.ports.GenderRepository;
import com.api.mangafy.domain.Gender;
import com.api.mangafy.infra.mapper.GenderMapper;

@Repository
public class GenderRepositoryImpl implements GenderRepository {
	private final GenderEntityRepository jpaRepository;

	public GenderRepositoryImpl(GenderEntityRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public List<Gender> findAllById(List<Integer> ids) {
		return this.jpaRepository.findAllById(ids).stream().map(GenderMapper::toDomain).toList();
	}

}
