package com.example.Springbootproject.repositories;

import com.example.Springbootproject.models.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<UserFile, Integer> {
}
