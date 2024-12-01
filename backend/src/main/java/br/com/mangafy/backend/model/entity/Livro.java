package br.com.mangafy.backend.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "livro")
public class Livro {
	@Id
	@Column(name = "id_livro")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column
	private Autor autor;
	
	@Column(name = "qtd_paginas", nullable = false)
	private int qrdPaginas;
}
