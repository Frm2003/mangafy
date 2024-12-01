package br.com.mangafy.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mangafy.backend.model.entity.Capitulo;

@Repository
public interface CapituloRepository extends JpaRepository<Capitulo, UUID> {
	
}
