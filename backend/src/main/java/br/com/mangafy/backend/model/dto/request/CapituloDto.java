package br.com.mangafy.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CapituloDto(
		@NotNull int numCapitulo,
		@NotNull int qtdPaginas,
		@NotBlank String path
) {

}
