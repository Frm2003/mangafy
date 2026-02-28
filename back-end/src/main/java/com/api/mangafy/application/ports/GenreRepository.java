package com.api.mangafy.application.ports;

import java.util.List;

import com.api.mangafy.domain.Genre;

public interface GenreRepository {
	List<Genre> findAllById(List<Integer> ids);
}
