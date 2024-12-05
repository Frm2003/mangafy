package br.com.mangafy.backend.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.api.model.dto.request.AutorDto;
import br.com.mangafy.backend.api.model.entity.Autor;
import br.com.mangafy.backend.api.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;

	public Autor insert(AutorDto autorDto) {
		Autor autor = new Autor(autorDto.nome(), autorDto.email(), autorDto.senha(), autorDto.createdAt(),
				autorDto.updatedAt());
		return this.autorRepository.save(autor);
	}
}
