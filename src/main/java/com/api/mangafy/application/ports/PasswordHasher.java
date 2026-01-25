package com.api.mangafy.application.ports;

public interface PasswordHasher {
    String hash(String rawPassword);
}

