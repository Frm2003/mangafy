package com.api.mangafy.infra.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "publications")
public class PublicationEntity {
	@Id
	private UUID id;

	private String title;

	@Column(columnDefinition = "TEXT")
	private String synopsis;

	@Column(name = "lauch_date")
	private LocalDateTime launchDate;

	@Column(unique = true)
	private String isbn10;

	@Column(unique = true)
	private String isbn13;

	@Column(name = "content_storage_url", unique = true)
	private String contentStorageUrl;

	@Column(name = "cover_storage_url", unique = true)
	private String coverStorageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private AuthorProfileEntity author;

	@ManyToMany
	@JoinTable(name = "publication_genders", joinColumns = @JoinColumn(name = "publication_id"), inverseJoinColumns = @JoinColumn(name = "gender_id"))
	private List<GenderEntity> genders;
}
