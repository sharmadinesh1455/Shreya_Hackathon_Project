package com.example.Springbootproject.controllers;

import com.example.Springbootproject.models.UserDetails;
import com.example.Springbootproject.models.UserFile;
import com.example.Springbootproject.repositories.UserRepository;
import com.example.Springbootproject.services.FileService;
import com.example.Springbootproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Value("${project.image}")
    private String filePath;

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    private UserRepository userRepository;


    @PostMapping("/uploadUserData")
    public ResponseEntity<UserDetails> uploadUsersData(@RequestBody UserDetails userDetails){
        UserDetails userData = this.userService.uploadUsersData(userDetails);
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

//    @PostMapping("/uploadFile/{userId}")
//    public ResponseEntity<UserFile> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Integer userId){
//
//        UserDetails userDetails = this.userRepository.findById(userId).get();
//        System.out.println("userDetails"+ userDetails.toString());
//
//        String fileName = this.fileService.uploadImageFile(filePath, file);
//        userFile.setFileName(fileName);
//        return new ResponseEntity<>(userFile, HttpStatus.OK);
//    }
}
