package br.com.mangafy.backend.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapituloDto(
		@NotNull int numCapitulo,
		@NotNull int qtdPaginas,
		@NotBlank String path,
		@NotBlank UUID idManga
) {

}
