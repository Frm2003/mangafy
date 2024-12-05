package br.com.mangafy.backend.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mangafy.backend.api.model.dto.request.AutorDto;
import br.com.mangafy.backend.api.service.AutorService;
import jakarta.validation.Valid;

@Controller
public class AutorController {
	@Autowired
	private AutorService autorService; 
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody @Valid AutorDto autorDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(this.autorService.insert(autorDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
