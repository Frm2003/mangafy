package br.com.mangafy.backend.api.model.entity;

import java.util.UUID;

import lombok.Data;

@Data
public class Autor {
	private UUID id;
	
	public Autor() {
		this.id = UUID.randomUUID();
	}
}
