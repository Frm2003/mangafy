package br.com.mangafy.backend.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.domain.model.dto.request.EditoraDto;
import br.com.mangafy.backend.domain.model.entity.Editora;
import br.com.mangafy.backend.domain.repository.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	private EditoraRepository editoraRepository;

	public Editora insert(EditoraDto editoraDto) {
		Editora editora = new Editora(editoraDto.nome(), editoraDto.email(), editoraDto.senha(), editoraDto.createdAt(),
				editoraDto.updatedAt());
		return this.editoraRepository.save(editora);
	}
}
