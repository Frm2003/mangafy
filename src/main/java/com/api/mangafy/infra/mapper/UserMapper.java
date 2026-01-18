package com.api.mangafy.infra.mapper;

import com.api.mangafy.domain.User;
import com.api.mangafy.infra.entity.UserEntity;

public class UserMapper {
	public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setNickName(user.getNickName());
        entity.setPasswd(user.getPasswd());
        entity.setRoles(user.getRoles());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        User user = new User();
        user.setId(entity.getId());
        user.setEmail(entity.getEmail());
        user.setName(entity.getName());
        user.setNickName(entity.getNickName());
        user.setPasswd(entity.getPasswd());
        user.setRoles(entity.getRoles());
        return user;
    }
}
