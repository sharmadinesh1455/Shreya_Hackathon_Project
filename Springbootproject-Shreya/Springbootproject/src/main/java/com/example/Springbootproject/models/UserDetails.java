package com.example.Springbootproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Please Enter Name")
    private String name;
    @NotEmpty(message = "Please Enter Phone Number")
    private String phoneNumber;

    @NotEmpty(message = "Please Enter Email")
    @Email(message = "Please Enter Valid Email")
    private String email;

//    @OneToOne
//    private UserFile file;

    public UserDetails() {
    }

    public UserDetails(Integer id, String name, String phoneNumber, String email, UserFile file) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
//        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public UserFile getFile() {
//        return file;
//    }
//
//    public void setFile(UserFile file) {
//        this.file = file;
//    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
