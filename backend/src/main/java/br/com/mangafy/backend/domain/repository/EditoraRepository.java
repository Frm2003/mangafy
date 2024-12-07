package br.com.mangafy.backend.domain.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.domain.model.entity.Autor;
import br.com.mangafy.backend.domain.model.entity.Editora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class EditoraRepository {
	private final String role = "EDITORA";
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Editora save(Editora editora) {
		String sql = "INSERT INTO usuarios (id_user, nome, email, senha, createdAt, updateAt, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, editora.getId());
		nativeQuery.setParameter(2, editora.getNome());
		nativeQuery.setParameter(3, editora.getEmail());
		nativeQuery.setParameter(4, editora.getSenha());
		nativeQuery.setParameter(5, editora.getCreatedAt());
		nativeQuery.setParameter(6, editora.getUpdatedAt());
		nativeQuery.setParameter(7, this.role);

		return editora;
	}
	
	public Optional<Editora> findById(UUID id) {
		String sql = "SELECT * FROM usuarios WHERE id_user = ? ";

		Query nativeQuery = this.entityManager.createNativeQuery(sql);
		nativeQuery.setParameter(1, id);

		try {
			Editora editora = (Editora) nativeQuery.getSingleResult();
			return Optional.of(editora);
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
