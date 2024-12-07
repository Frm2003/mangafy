package br.com.mangafy.backend.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.domain.model.dto.request.LivroDto;
import br.com.mangafy.backend.domain.model.entity.Autor;
import br.com.mangafy.backend.domain.model.entity.Livro;
import br.com.mangafy.backend.domain.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorService autorService;
	
	public Livro insert(LivroDto livroDto) {
		Autor autor = this.autorService.selectById(livroDto.idAutor());
	
		Livro livro = new Livro();
		livro.setTitulo(livroDto.titulo());
		livro.setAutor(autor);
		livro.setGenero(livroDto.genero());
		livro.setPath("" + livroDto.titulo());
		livro.setQtdPaginas(livroDto.qtdPaginas());
		
		return livroRepository.save(livro);
	}
}
