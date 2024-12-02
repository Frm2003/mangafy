package br.com.mangafy.backend.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.api.model.entity.Manga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class MangaRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Manga save(Manga manga) {
		String sql = "INSERT INTO mangas (id_manga, titulo, autor, qtd_capitulos) VALUES (?, ?, ?, ?)";
		
		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		
		nativeQuery.setParameter(1, manga.getId());
		nativeQuery.setParameter(2, manga.getTitulo());
		nativeQuery.setParameter(3, manga.getAutor().getId());
		nativeQuery.setParameter(4, manga.getQtdCapitulos());
		
		nativeQuery.executeUpdate();
		
		return manga;
	}
	
	public Optional<Manga> findById(UUID id) {
		String sql = "SELECT * FROM mangas WHERE id_manga = ? ";
		
		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, id);
		
		try {
			Manga manga = (Manga) nativeQuery.getSingleResult();
			return Optional.of(manga);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
