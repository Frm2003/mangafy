package br.com.mangafy.backend.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mangafy.backend.domain.model.dto.request.LivroDto;
import br.com.mangafy.backend.domain.service.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody @Valid LivroDto livroDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(livroService.insert(livroDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
