package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.repository.ISongRepository;
import com.example.zingfakebackend.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SongController {
      @Autowired
      ISongService songService;

      @Autowired
      ISongRepository songRepository;

      @GetMapping("/allSongs")
      public ResponseEntity<Iterable<Song>> listSongs() {
            Iterable<Song> songs = songService.findAll();
            if (songs == null) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(songs, HttpStatus.OK);
      }

      @GetMapping("/songs/{id}")
      public ResponseEntity<Song> getSongById(@PathVariable long id) {
            return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
      }

      @PostMapping("/songs")
      public ResponseEntity<Song> createSong(@RequestBody Song song) {
            songService.save(song);
            return new ResponseEntity<>(song, HttpStatus.CREATED);
      }

      @PutMapping("/song/{id}")
      public ResponseEntity<Song> updateSongInfo(@PathVariable long id, @RequestBody Song song) {
            Song currentSong = songService.findById(id);
            if (currentSong == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentSong.setName(song.getName());
            currentSong.setDescription(song.getDescription());
            currentSong.setImg(song.getImg());
            currentSong.setArtist(song.getArtist());
            currentSong.setDate(song.getDate());
            currentSong.setGenre(song.getGenre());
            currentSong.setPlays(song.getPlays());
            currentSong.setLikes(song.getLikes());

            songService.save(currentSong);
            return new ResponseEntity<>(currentSong, HttpStatus.OK);
      }

      @DeleteMapping("/song/{id}")
      public ResponseEntity<Song> deleteSong(@PathVariable("id") long id) {
            Song song = songService.findById(id);
            if (song == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            songService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/songs/plays/desc")
      public ResponseEntity<Iterable<Song>> songOrderByPlaysDesc() {
            Iterable<Song> songPlays = songRepository.findByOrderByPlaysDesc();
            return new ResponseEntity<>(songPlays, HttpStatus.OK);
      }

      @GetMapping("/songs/likes/desc")
      public ResponseEntity<Iterable<Song>> songOrderByLikesDesc() {
            Iterable<Song> songLikes = songRepository.findByOrderByLikesDesc();
            return new ResponseEntity<>(songLikes, HttpStatus.OK);
      }

      @GetMapping("/songs/date/desc")
      public ResponseEntity<Iterable<Song>> songOrderByDateDesc() {
            Iterable<Song> songDate = songRepository.findByOrderByDateDesc();
            return new ResponseEntity<>(songDate, HttpStatus.OK);
      }

      @GetMapping("/songs/{name}")
      public ResponseEntity<Iterable<Song>> findSongByNameContaining(@PathVariable String name) {
            return new ResponseEntity<>(songService.findSongByName(name), HttpStatus.OK);
      }


}
