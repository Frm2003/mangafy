package br.com.mangafy.backend.domain.model.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Manga {
	private UUID id;
	private String titulo;
	private Autor autor;
	private int qtdCapitulos;
	private String genero;
	
	public Manga() {
		this.id = UUID.randomUUID();
	}
}
