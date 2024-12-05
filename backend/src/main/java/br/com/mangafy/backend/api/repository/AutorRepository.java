package br.com.mangafy.backend.api.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.api.model.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class AutorRepository {
	private final String role = "AUTOR";
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Autor save(Autor autor) {
		String sql = "INSERT INTO usuarios (id_user, nome, email, senha, createdAt, updateAt, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, autor.getId());
		nativeQuery.setParameter(2, autor.getNome());
		nativeQuery.setParameter(3, autor.getEmail());
		nativeQuery.setParameter(4, autor.getSenha());
		nativeQuery.setParameter(5, autor.getCreatedAt());
		nativeQuery.setParameter(6, autor.getUpdatedAt());
		nativeQuery.setParameter(7, this.role);

		return autor;
	}

	public Optional<Autor> findById(UUID id) {
		String sql = "SELECT * FROM usuarios WHERE id_user = ? ";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, id);

		try {
			Autor autor = (Autor) nativeQuery.getSingleResult();
			return Optional.of(autor);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Autor> findAll() {
		String sql = "SELECT * FROM usuarios WHERE role = ?";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, this.role);

		try {
			List<Autor> autores = nativeQuery.getResultList();
			return autores;
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

}
