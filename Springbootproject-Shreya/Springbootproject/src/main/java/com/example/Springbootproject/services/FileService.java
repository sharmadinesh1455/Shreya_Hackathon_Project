package com.example.Springbootproject.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadImageFile(String path, MultipartFile file) throws IOException;
}
