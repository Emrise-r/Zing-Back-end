package com.example.zingfakebackend.model;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @NotEmpty
    private String name;

    private String description;

    private String cover_art_url;

    private String song_url;

//    @Transient
//    private MultipartFile imgFile;
//
//    @Transient
//    private MultipartFile songFile;

    private String artist;

    private Date date;

    private String genre;

    private Long plays;

    private Long likes;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

//    public MultipartFile getSongFile() {
//        return songFile;
//    }
//
//    public void setSongFile(MultipartFile songFile) {
//        this.songFile = songFile;
//    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_art_url() {
        return cover_art_url;
    }

    public void setCover_art_url(String cover_art_url) {
        this.cover_art_url = cover_art_url;
    }

//    public MultipartFile getImgFile() {
//        return imgFile;
//    }

//    public void setImgFile(MultipartFile imgFile) {
//        this.imgFile = imgFile;
//    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getPlays() {
        return plays;
    }

    public void setPlays(Long plays) {
        this.plays = plays;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song() {
    }


}
