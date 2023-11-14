package com.example.Springbootproject.serviceImpl;

import com.example.Springbootproject.models.UserDetails;
import com.example.Springbootproject.repositories.UserRepository;
import com.example.Springbootproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails uploadUsersData(UserDetails userDetails) {

        UserDetails userDetails1 = this.userRepository.save(userDetails);
        return userDetails;
    }
}
