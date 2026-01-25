package com.api.mangafy.application.ports;

import java.util.List;

import com.api.mangafy.domain.Gender;

public interface GenderRepository {
	List<Gender> findAllById(List<Integer> ids);
}
