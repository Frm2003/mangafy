package com.api.mangafy.application;

import com.api.mangafy.adapters.dto.LoginDto;

public interface AuthService {
	String login(LoginDto dto);
}
