package com.api.mangafy.adapters.dto;

public record CreateUserDto (
         String email,
         String name,
         String nickName,
         String passwd
) {
	
}
