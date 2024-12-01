package br.com.mangafy.backend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.model.dto.request.LivroDto;
import br.com.mangafy.backend.model.entity.Livro;
import br.com.mangafy.backend.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro insert(LivroDto livroDto) {
		Livro livro = new Livro();
		BeanUtils.copyProperties(livroDto, livro);
		return livroRepository.save(livro);
	}
}
