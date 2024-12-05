package br.com.mangafy.backend.api.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor extends Usuario {
	// DEFINIER ATRIBUTOS
	public Autor(String nome, String email, String senha, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super(UUID.randomUUID(), nome, email, senha, createdAt, updatedAt, "AUTOR");
	}

}
