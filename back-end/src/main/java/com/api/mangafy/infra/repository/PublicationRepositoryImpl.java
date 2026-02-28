package com.api.mangafy.infra.repository;

import org.springframework.stereotype.Repository;

import com.api.mangafy.application.ports.PublicationRepository;
import com.api.mangafy.domain.Publication;
import com.api.mangafy.infra.entity.PublicationEntity;
import com.api.mangafy.infra.mapper.PublicationMapper;

@Repository
public class PublicationRepositoryImpl implements PublicationRepository {
	private final PublicationEntityRepository PublicationJpaRepository;

	public PublicationRepositoryImpl(PublicationEntityRepository publicationJpaRepository) {
		this.PublicationJpaRepository = publicationJpaRepository;
	}

	@Override
	public Publication create(Publication publication) {
		PublicationEntity entity = PublicationMapper.toEntity(publication);	
		entity = this.PublicationJpaRepository.save(entity);
		return PublicationMapper.toDomain(entity);
	}

}
