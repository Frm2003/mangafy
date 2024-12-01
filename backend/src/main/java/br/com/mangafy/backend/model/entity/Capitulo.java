package br.com.mangafy.backend.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "capitulo_manga")
public class Capitulo {
	@Id
	@Column(name = "id_livro")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "num_capitulo", nullable = false)
	private int numCapitulo;

	@Column(name = "qtd_paginas", nullable = false)
	private int qtdPaginas;

	@Column(nullable = false)
	private String path;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_manga", nullable = false)
	private Manga manga;
}
