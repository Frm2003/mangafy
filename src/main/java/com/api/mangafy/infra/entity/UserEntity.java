package com.api.mangafy.infra.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.api.mangafy.domain.Roles;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor
@Setter
@Table(name = "users")
public class UserEntity {
	@Id
	private UUID id;

	@Column(length = 40, nullable = false, unique = true)
	private String email;

	@Column(length = 40, nullable = false)
	private String name;

	@Column(length = 40, name = "nick_name", nullable = false)
	private String nickName;

	@Column(length = 255, nullable = false)
	private String passwd;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Set<Roles> roles = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true, optional = true)
	private AuthorProfileEntity authorProfile;
}
