package br.com.mangafy.backend.domain.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Usuario {
	private UUID id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String role;
}
