package com.api.mangafy.infra.service;

import io.minio.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.api.mangafy.application.ports.StorageService;

import java.io.InputStream;

@Service
public class MinioStorageService implements StorageService {
    @Value("${storage.bucket-name}")
    private String bucketName;

    private final MinioClient minioClient;

    public MinioStorageService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public String upload(String fileName, InputStream stream, String contentType, long size) {
        try {
            PutObjectArgs args = PutObjectArgs.builder().bucket(this.bucketName).object(fileName).stream(stream, size, -1).contentType(contentType).build();
            ObjectWriteResponse response = this.minioClient.putObject(args);
            return response.object();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InputStream download(String fileName) {
        try {
            GetObjectArgs args = GetObjectArgs.builder().bucket(this.bucketName).object(fileName).build();
            return this.minioClient.getObject(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String fileName) {
        try {
            RemoveObjectArgs args = RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build();
            minioClient.removeObject(args);
            return true;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	return false;
        }
    }
}
