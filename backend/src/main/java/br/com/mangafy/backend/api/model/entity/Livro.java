package br.com.mangafy.backend.api.model.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Livro {
	private UUID id;
	private String titulo;
	private Autor autor;
	private Editora editora;
	private int qtdPaginas;
	private String genero;
	private String path;
	
	public Livro() {
		this.id = UUID.randomUUID();
	}
}
