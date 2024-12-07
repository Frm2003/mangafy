package br.com.mangafy.backend.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mangafy.backend.domain.model.dto.request.EditoraDto;
import br.com.mangafy.backend.domain.service.EditoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/editoras")
public class EditoraController {
	@Autowired
	private EditoraService editoraService;
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody @Valid EditoraDto editoraDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.editoraService.insert(editoraDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
