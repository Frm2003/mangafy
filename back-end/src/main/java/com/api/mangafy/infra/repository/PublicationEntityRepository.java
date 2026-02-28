package com.api.mangafy.infra.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mangafy.infra.entity.PublicationEntity;

public interface PublicationEntityRepository extends JpaRepository<PublicationEntity, UUID> {
	
}
