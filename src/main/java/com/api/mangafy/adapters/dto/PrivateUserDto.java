package com.api.mangafy.adapters.dto;

import java.util.UUID;

import com.api.mangafy.domain.User;

import lombok.Getter;

@Getter
public class PrivateUserDto {
	private UUID id;
	private String email;
	private String name;
	private String nickName;
	private String cpf;
	private String cnpj;

	public PrivateUserDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.nickName = user.getNickName();

		if (user.getAuthorProfile() != null) {
			this.cpf = user.getAuthorProfile().getCpf();
			this.cnpj = user.getAuthorProfile().getCnpj();
		}
	}
}
