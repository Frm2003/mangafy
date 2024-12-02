package br.com.mangafy.backend.repository;

import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.model.entity.Capitulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CapituloRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Capitulo save(Capitulo capitulo) {
		String sql = "INSERT INTO capitulo_manga (id_livro, num_capitulo, qtd_paginas, path, id_manga) VALUES (?, ?, ?, ?, ?)";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, capitulo.getId());
		nativeQuery.setParameter(2, capitulo.getNumCapitulo());
		nativeQuery.setParameter(3, capitulo.getQtdPaginas());
		nativeQuery.setParameter(4, capitulo.getPath());
		nativeQuery.setParameter(5, capitulo.getManga().getId());
		
		nativeQuery.executeUpdate();
		
		return capitulo;
	}
}
