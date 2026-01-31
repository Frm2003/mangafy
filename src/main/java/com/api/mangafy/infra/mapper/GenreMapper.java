package com.api.mangafy.infra.mapper;

import com.api.mangafy.domain.Genre;
import com.api.mangafy.infra.entity.GenreEntity;

public class GenreMapper {
	public static Genre toDomain(GenreEntity entity) {
		return new Genre(entity.getId(), entity.getDescription());
	}
	
	public static GenreEntity toEntity(Genre Genre) {
		return new GenreEntity(Genre.getId(), Genre.getDescription());
	}
}
