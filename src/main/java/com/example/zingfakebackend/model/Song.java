package com.example.zingfakebackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    private String song_url;

    private String artist;

    private Date date;

    private String genre;

    @Column(name = "plays")
    private long plays = 0;

    @Column(name = "likes")
    private long likes = 0;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

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

    public long getPlays() {
        return plays;
    }

    public void setPlays(long plays) {
        this.plays = plays;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
