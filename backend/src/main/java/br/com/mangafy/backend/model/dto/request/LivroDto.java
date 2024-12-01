package br.com.mangafy.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDto(
	    @NotBlank String titulo,
	    @NotBlank String autor,
		@NotNull int qtdPaginas
) {

}
