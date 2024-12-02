package br.com.mangafy.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mangafy.backend.model.dto.request.CapituloDto;
import br.com.mangafy.backend.service.CapituloService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/capitulos")
public class CapituloController {
	@Autowired
	private CapituloService capituloService;

	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody @Valid UUID idManga, @RequestBody @Valid List<CapituloDto> list) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(capituloService.insert(idManga, list));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
