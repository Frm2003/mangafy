package br.com.mangafy.backend.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "manga")
public class Manga {
	@Id
	@Column(name = "id_manga")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column
	private String titulo;
	
	@Column
	private Autor autor;
	
	@Column(name = "qtd_capitulos")
	private int qtdCapitulos;
}
