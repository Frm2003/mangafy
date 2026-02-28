package com.api.mangafy.infra.mapper;

import com.api.mangafy.domain.AuthorProfile;
import com.api.mangafy.infra.entity.AuthorProfileEntity;
import com.api.mangafy.infra.entity.UserEntity;

public class AuthorProfileMapper {

    public static AuthorProfileEntity toEntity(AuthorProfile profile, UserEntity userEntity) {
        if (userEntity == null || profile == null) return null;

        AuthorProfileEntity entity = new AuthorProfileEntity();
        entity.setId(userEntity.getId());
        entity.setCpf(profile.getCpf());
        entity.setCnpj(profile.getCnpj());
        entity.setUser(userEntity);
        return entity;
    }

    public static AuthorProfile toDomain(AuthorProfileEntity entity) {
        if (entity == null) return null;

        return new AuthorProfile(
            entity.getCpf(),
            entity.getCnpj()
        );
    }

}
