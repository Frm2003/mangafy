package com.api.mangafy.infra.mapper;

import com.api.mangafy.domain.Gender;
import com.api.mangafy.infra.entity.GenderEntity;

public class GenderMapper {
	public static Gender toDomain(GenderEntity entity) {
		return new Gender(entity.getId(), entity.getDescription());
	}
	
	public static GenderEntity toEntity(Gender gender) {
		return new GenderEntity(gender.getId(), gender.getDescription());
	}
}
