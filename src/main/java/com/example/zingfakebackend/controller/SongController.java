package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@CrossOrigin("*")
@RequestMapping("/song")
public class SongController {

    @Autowired
    Environment evn;

    @Autowired
    ISongService iSongService;


    @PostMapping(value = "/create", consumes = {"multipart/form-data"})
    public ResponseEntity<Song> create(@RequestBody Song songForm) {
//        MultipartFile imgFile = songForm.getImgFile();
//        MultipartFile songFile = songForm.getSongFile();
//        String imgName = imgFile.getOriginalFilename();
//        String songFileName = songFile.getOriginalFilename();
//        songForm.setCover_art_url(evn.getProperty("file_imgSong") + imgName);
//        songForm.setSong_url(evn.getProperty("file_song") + songFileName);
//        try {
//            FileCopyUtils.copy(imgFile.getBytes(), new File(songForm.getCover_art_url()));
//            FileCopyUtils.copy(songFile.getBytes(), new File(songForm.getSong_url()));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        Song song = new Song();
        song.setName(songForm.getName());
        song.setArtist(songForm.getArtist());
        song.setDate(songForm.getDate());
        song.setDescription(songForm.getDescription());
        song.setArtist(songForm.getArtist());
        song.setGenre(songForm.getGenre());
        song.setCover_art_url(songForm.getCover_art_url());
        song.setSong_url(songForm.getSong_url());
        iSongService.save(song);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
