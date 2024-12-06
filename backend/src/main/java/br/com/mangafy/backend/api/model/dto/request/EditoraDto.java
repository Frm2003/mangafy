package br.com.mangafy.backend.api.model.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record EditoraDto(
		@NotBlank String nome,
	    @NotBlank String email,
	    @NotBlank String senha,
	    @NotBlank LocalDateTime createdAt,
	    @NotBlank LocalDateTime updatedAt
) {
	
}
