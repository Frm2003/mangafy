package br.com.mangafy.backend.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mangafy.backend.domain.model.dto.request.MangaDto;
import br.com.mangafy.backend.domain.service.MangaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mangas")
public class MangaController {
	@Autowired
	private MangaService mangaService;
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody @Valid MangaDto mangaDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(mangaService.insert(mangaDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
