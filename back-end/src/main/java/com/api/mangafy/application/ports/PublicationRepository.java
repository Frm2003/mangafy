package com.api.mangafy.application.ports;

import com.api.mangafy.domain.Publication;

public interface PublicationRepository {
	Publication create(Publication publication);
}
