package com.api.mangafy.infra.mapper;

import java.util.List;

import com.api.mangafy.domain.Gender;
import com.api.mangafy.domain.Publication;
import com.api.mangafy.domain.User;
import com.api.mangafy.infra.entity.AuthorProfileEntity;
import com.api.mangafy.infra.entity.GenderEntity;
import com.api.mangafy.infra.entity.PublicationEntity;
import com.api.mangafy.infra.entity.UserEntity;

public class PublicationMapper {
	public static PublicationEntity toEntity(Publication publication) {
		UserEntity userEntity = UserMapper.toEntity(publication.getUser());

		AuthorProfileEntity authorProfileEntity = AuthorProfileMapper.toEntity(publication.getUser().getAuthorProfile(),
				userEntity);

		List<GenderEntity> genders = publication.getGenders().stream().map(GenderMapper::toEntity).toList();

		PublicationEntity entity = new PublicationEntity();

		entity.setId(publication.getId());
		entity.setTitle(publication.getTitle());
		entity.setSynopsis(publication.getSynopsis());
		entity.setLaunchDate(publication.getLaunchDate());
		entity.setIsbn10(publication.getISBN10());
		entity.setIsbn13(publication.getISBN13());
		entity.setContentStorageUrl(publication.getContentStorageUrl());
		entity.setCoverStorageUrl(publication.getCoverStorageUrl());

		entity.setGenders(genders);
		entity.setAuthor(authorProfileEntity);

		return entity;
	}

	public static Publication toDomain(PublicationEntity entity) {
		if (entity == null)
			return null;

		User user = UserMapper.toDomain(entity.getAuthor().getUser());

		List<Gender> genders = entity.getGenders().stream().map(GenderMapper::toDomain).toList();

		Publication publication = new Publication();
		publication.setId(entity.getId());
		publication.setTitle(entity.getTitle());
		publication.setSynopsis(entity.getSynopsis());
		publication.setLaunchDate(entity.getLaunchDate());
		publication.setISBN10(entity.getIsbn10());
		publication.setISBN13(entity.getIsbn13());
		publication.setContentStorageUrl(entity.getContentStorageUrl());

		publication.setUser(user);
		publication.setGenders(genders);

		return publication;
	}
}
