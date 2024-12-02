package br.com.mangafy.backend.model.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Livro {
	private UUID id;
	private String titulo;
	private Autor autor;
	private int qtdPaginas;
	
	public Livro() {
		this.id = UUID.randomUUID();
	}
}
