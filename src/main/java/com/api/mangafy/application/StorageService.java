package com.api.mangafy.application;

import java.io.InputStream;

public interface StorageService {
    String upload(String fileName, InputStream stream, String contentType, long size);
    InputStream download(String fileName);
    boolean delete(String fileName);
}
