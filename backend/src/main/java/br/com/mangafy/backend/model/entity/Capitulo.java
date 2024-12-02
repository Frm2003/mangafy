package br.com.mangafy.backend.model.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Capitulo {
	private UUID id;
	private int numCapitulo;
	private int qtdPaginas;
	private String path;
	private Manga manga;
	
	public Capitulo() {
		this.id = UUID.randomUUID();
	}
}
