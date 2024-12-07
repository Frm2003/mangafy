package br.com.mangafy.backend.domain.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.domain.model.dto.request.AutorDto;
import br.com.mangafy.backend.domain.model.entity.Autor;
import br.com.mangafy.backend.domain.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;

	public Autor insert(AutorDto autorDto) {
		Autor autor = new Autor(autorDto.nome(), autorDto.email(), autorDto.senha(), autorDto.createdAt(),
				autorDto.updatedAt());
		return this.autorRepository.save(autor);
	}
	
	public Autor selectById(UUID id) {
		Optional<Autor> optional = autorRepository.findById(id);
		return optional.orElseThrow(() -> new NoSuchElementException("Autor não encontrado com o id: " + id));
	}
}
