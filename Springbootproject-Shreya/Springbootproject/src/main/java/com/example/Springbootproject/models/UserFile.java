package com.example.Springbootproject.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fileId;
    private String fileName;

//    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private UserDetails userDetails;
}
