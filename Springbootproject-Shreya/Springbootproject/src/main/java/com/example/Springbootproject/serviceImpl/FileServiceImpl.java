package com.example.Springbootproject.serviceImpl;

import com.example.Springbootproject.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImageFile(String path, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println("FileName ---- "+fileName);
        String randomStringId = UUID.randomUUID().toString();
        String finalFileName = randomStringId.concat(fileName.substring(fileName.lastIndexOf(".")));
        System.out.println("finalFileName ---- "+finalFileName);
        String fullPath = path+ File.separator+finalFileName;
        System.out.println("fullPath ---- "+fullPath);

        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(fullPath));

        return finalFileName;
    }
}
