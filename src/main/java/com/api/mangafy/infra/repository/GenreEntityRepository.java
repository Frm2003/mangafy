package com.api.mangafy.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mangafy.infra.entity.GenreEntity;

public interface GenreEntityRepository extends JpaRepository<GenreEntity, Integer>{
	
}
