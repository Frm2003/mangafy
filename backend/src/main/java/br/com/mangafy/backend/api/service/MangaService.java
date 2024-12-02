package br.com.mangafy.backend.api.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mangafy.backend.api.model.dto.request.MangaDto;
import br.com.mangafy.backend.api.model.entity.Manga;
import br.com.mangafy.backend.api.repository.MangaRepository;

@Service
public class MangaService {
	@Autowired
	private MangaRepository mangaRepository;

	public Manga insert(MangaDto mangaDto) {
		Manga manga = new Manga();
		BeanUtils.copyProperties(mangaDto, manga);
		return mangaRepository.save(manga);
	}

	public Manga selectById(UUID id) {
		Optional<Manga> optional = mangaRepository.findById(id);
		return optional.orElseThrow(() -> new NoSuchElementException("Manga não encontrado com o id: " + id));
	}
}
