package br.com.mangafy.backend.domain.model.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDto(
	    @NotBlank String titulo,
	    @NotBlank String genero,
	    @NotNull UUID idAutor,
		@NotNull int qtdPaginas
) {

}
