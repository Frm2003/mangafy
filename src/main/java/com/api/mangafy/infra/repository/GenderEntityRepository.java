package com.api.mangafy.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mangafy.infra.entity.GenderEntity;

public interface GenderEntityRepository extends JpaRepository<GenderEntity, Integer>{
	
}
