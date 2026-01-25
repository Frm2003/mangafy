package com.api.mangafy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class User {
	private UUID id;
	private String email;
	private String name;
	private String nickName;
	private String passwd;
	private Set<Roles> roles;

	private AuthorProfile authorProfile;
}
