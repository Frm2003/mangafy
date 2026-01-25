package com.api.mangafy.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Publication {
	private UUID id;
	private User user;
	private String title;
	private String synopsis;
	private LocalDateTime launchDate;
	private String ISBN10;
	private String ISBN13;
	private String contentStorageUrl;
}
