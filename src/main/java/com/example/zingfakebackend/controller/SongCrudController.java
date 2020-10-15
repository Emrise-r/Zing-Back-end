//package com.example.zingfakebackend.controller;
//
//import com.example.zingfakebackend.model.Song;
//import com.example.zingfakebackend.service.song.ISongService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/songCrud")
//public class SongCrudController {
//      @Autowired
//      ISongService songService;
//      @PostMapping("/create")
//      public ResponseEntity<Song> createSong(@RequestBody Song song) {
//            songService.save(song);
//            return new ResponseEntity<>(song, HttpStatus.CREATED);
//      }
//
//      @PutMapping("/update/{id}")
//      public ResponseEntity<Song> updateSongInfo(@PathVariable long id, @RequestBody Song song) {
//            Song currentSong = songService.findById(id);
//            if (currentSong == null) {
//                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            currentSong.setName(song.getName());
//            currentSong.setDescription(song.getDescription());
//            currentSong.setCover_art_url(song.getCover_art_url());
//            currentSong.setArtist(song.getArtist());
//            currentSong.setDate(song.getDate());
//            currentSong.setGenre(song.getGenre());
//            currentSong.setPlays(song.getPlays());
//            currentSong.setLikes(song.getLikes());
//
//            songService.save(currentSong);
//            return new ResponseEntity<>(currentSong, HttpStatus.OK);
//      }
//
//      @DeleteMapping("/delete/{id}")
//      public ResponseEntity<Song> deleteSong(@PathVariable("id") long id) {
//            Song song = songService.findById(id);
//            if (song == null) {
//                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            songService.remove(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//      }
//}
