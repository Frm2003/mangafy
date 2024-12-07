package br.com.mangafy.backend.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.domain.model.dto.request.CapituloDto;
import br.com.mangafy.backend.domain.model.entity.Capitulo;
import br.com.mangafy.backend.domain.model.entity.Manga;
import br.com.mangafy.backend.domain.repository.CapituloRepository;

@Service
public class CapituloService {
	@Autowired
	private CapituloRepository capituloRepository;
	
	@Autowired
	private MangaService MangaService;
	
	public List<Capitulo> insert(UUID idManga, List<CapituloDto> listDto) {
		List<Capitulo> capitulos = new ArrayList<Capitulo>();
		
		Manga manga = MangaService.selectById(idManga);
		
		listDto.forEach(capituloDto -> {
			Capitulo capitulo = new Capitulo();
			
			capitulo.setNumCapitulo(capituloDto.numCapitulo());
			capitulo.setPath(capituloDto.path());
			capitulo.setQtdPaginas(capituloDto.qtdPaginas());
			capitulo.setManga(manga);
			
			capitulos.add(capituloRepository.save(capitulo));
		});
		
		return capitulos;
	}
}
