package br.com.mangafy.backend.domain.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MangaDto(
		@NotBlank String titulo,
		@NotBlank String autor,
		@NotNull int qtdCapitulos,
		@NotBlank String genero
) {

}
