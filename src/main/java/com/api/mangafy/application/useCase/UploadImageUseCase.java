package com.api.mangafy.application.useCase;

import java.io.InputStream;
import java.util.UUID;

import com.api.mangafy.application.ports.StorageService;

public class UploadImageUseCase {
	private final StorageService service;

	public UploadImageUseCase(StorageService service) {
		this.service = service;
	}
	
	public String execute(UUID authorId, String category, String fileName, InputStream stream, String contentType, long size) {
		String path = authorId.toString() + "/" + category + "/" + fileName;		
		return this.service.upload(path, stream, contentType, size);
	}
}
