package br.com.mangafy.backend.model.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Manga {
	private UUID id;
	private String titulo;
	private Autor autor;
	private int qtdCapitulos;
	
	public Manga() {
		this.id = UUID.randomUUID();
	}
}
