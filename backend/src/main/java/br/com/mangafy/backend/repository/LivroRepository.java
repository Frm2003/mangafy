package br.com.mangafy.backend.repository;

import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.model.entity.Livro;
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
		String sql = "INSERT INTO livro (id_livro, titulo, id_autor, qtd_paginas) VALUES (?, ?, ?, ?)";
		
		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		
		nativeQuery.setParameter(1, livro.getId());
		nativeQuery.setParameter(2, livro.getTitulo());
		nativeQuery.setParameter(3, livro.getAutor().getId());
		nativeQuery.setParameter(4, livro.getQtdPaginas());
		
		nativeQuery.executeUpdate();
		
		return livro;
	}
}
