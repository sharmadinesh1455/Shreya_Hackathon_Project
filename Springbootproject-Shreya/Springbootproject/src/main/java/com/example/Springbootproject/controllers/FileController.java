package com.example.Springbootproject.controllers;

import com.example.Springbootproject.models.UserDetails;
import com.example.Springbootproject.models.UserFile;
import com.example.Springbootproject.repositories.FileRepository;
import com.example.Springbootproject.repositories.UserRepository;
import com.example.Springbootproject.services.FileService;
import com.example.Springbootproject.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @Value("${project.image}")
    private String filePath;

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;


    @PostMapping("/uploadFile/{userId}")
    public ResponseEntity<UserFile> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Integer userId) throws IOException {

        UserDetails userDetails = this.userRepository.findById(userId).get();
        System.out.println("userDetails"+ userDetails.toString());
        UserFile userFile = new UserFile();
        String fileName = this.fileService.uploadImageFile(filePath, file);
        userFile.setFileName(fileName);
        UserFile userFile1 = this.fileRepository.save(userFile);
        return new ResponseEntity<>(userFile1, HttpStatus.OK);
    }
}
