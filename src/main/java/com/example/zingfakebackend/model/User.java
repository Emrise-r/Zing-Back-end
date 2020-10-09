package com.example.zingfakebackend.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    @Min(3)
    @Max(15)
    private String name;

    @NotEmpty
    private String password;

    @Email
    private String email;

    private String account_url;

    public String getAccount_url() {
        return account_url;
    }

    public void setAccount_url(String account_url) {
        this.account_url = account_url;
    }

//    @OneToMany(mappedBy = "user")
//    private Set<Song> songs;
//
//    public Set<Song> getSongs() {
//        return songs;
//    }
//
//    public void setSongs(Set<Song> songs) {
//        this.songs = songs;
//    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
