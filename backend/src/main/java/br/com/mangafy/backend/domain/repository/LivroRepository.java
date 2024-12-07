package br.com.mangafy.backend.domain.repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.domain.model.entity.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class LivroRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Livro save(Livro livro) {
		String sql = "INSERT INTO livros (id_livro, titulo, id_autor, qtd_paginas, id_editora, genero, path) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		
		nativeQuery.setParameter(1, livro.getId());
		nativeQuery.setParameter(2, livro.getTitulo());
		nativeQuery.setParameter(3, livro.getAutor().getId());
		nativeQuery.setParameter(4, livro.getQtdPaginas());
		nativeQuery.setParameter(5, livro.getEditora().getId());
		nativeQuery.setParameter(6, livro.getGenero());
		nativeQuery.setParameter(7, livro.getPath());
		
		nativeQuery.executeUpdate();
		
		return livro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> findAllById(UUID id) {
		String sql = "SELECT * FROM livros WHERE id_autor = ? OR id_editora = ? ";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, id);
		nativeQuery.setParameter(2, id);

		try {
			List<Livro> livros = nativeQuery.getResultList();
			return livros;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
}
