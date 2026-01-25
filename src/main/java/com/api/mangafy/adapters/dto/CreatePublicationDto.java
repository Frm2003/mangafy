package com.api.mangafy.adapters.dto;

import java.time.LocalDateTime;

public record CreatePublicationDto(
        String title,
        String synopsis,
        LocalDateTime launchDate,
        String ISBN10,
        String ISBN13,
        String contentStorageUrl
) {

}
