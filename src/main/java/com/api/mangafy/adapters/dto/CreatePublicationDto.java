package com.api.mangafy.adapters.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CreatePublicationDto(
        String title,
        String synopsis,
        LocalDateTime launchDate,
        String ISBN10,
        String ISBN13,
        String contentStorageUrl,
        String coverStorageUrl,
        List<Integer> genderIds
) {

}
