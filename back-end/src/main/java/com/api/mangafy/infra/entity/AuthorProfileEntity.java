package com.api.mangafy.infra.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "author_profiles")
public class AuthorProfileEntity {
	@Id
	private UUID id;

	@Column(length = 11, unique = true, nullable = true)
	private String cpf;

	@Column(length = 14, unique = true, nullable = true)
	private String cnpj;

	@OneToOne(optional = false)
	@MapsId
	@JoinColumn(name = "id")
	private UserEntity user;
}
