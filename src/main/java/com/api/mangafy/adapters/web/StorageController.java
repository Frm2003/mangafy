package com.api.mangafy.adapters.web;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.api.mangafy.application.useCase.UploadImageUseCase;

@RestController
@RequestMapping("/storage")
public class StorageController {
	private final UploadImageUseCase uploadImageUseCase;

	public StorageController(UploadImageUseCase uploadImageUseCase) {
		this.uploadImageUseCase = uploadImageUseCase;
	}

	@PreAuthorize("hasRole('AUTHOR')")
	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> upload(
			@AuthenticationPrincipal Jwt jwt, 
			@RequestPart("image") MultipartFile image,
			@RequestParam String category,
			@RequestParam String type
	) {
		try {
			String path = this.uploadImageUseCase.execute(
				UUID.fromString(jwt.getSubject()), 
				category,
				type,
				image.getOriginalFilename(),
				image.getInputStream(), 
				image.getContentType(), 
				image.getSize()
			);
			return ResponseEntity.status(HttpStatus.OK).body(path);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	/*
	 * @GetMapping("/download/{fileName}") public
	 * ResponseEntity<InputStreamResource> download(@PathVariable String fileName) {
	 * try { return ResponseEntity .status(HttpStatus.OK)
	 * .contentType(MediaType.APPLICATION_OCTET_STREAM) .body(new
	 * InputStreamResource(this.storageService.download(fileName))); } catch
	 * (Exception e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	 * } }
	 * 
	 * @GetMapping("/delete/{fileName}") public ResponseEntity<Boolean>
	 * delete(@PathVariable String fileName) { try { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.storageService.delete(
	 * fileName)); } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false); } }
	 */
}
