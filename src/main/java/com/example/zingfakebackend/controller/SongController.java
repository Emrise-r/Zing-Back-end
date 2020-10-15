package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.model.Artist;
import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.model.User;
import com.example.zingfakebackend.repository.IArtistRepository;
import com.example.zingfakebackend.repository.ISongRepository;
import com.example.zingfakebackend.service.song.IArtistService;
import com.example.zingfakebackend.service.song.IPlaylistService;
import com.example.zingfakebackend.service.song.ISongService;
import com.example.zingfakebackend.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/song")
public class SongController {
      @Autowired
      ISongService songService;

      @Autowired
      ISongRepository songRepository;

      @Autowired
      IUserService userService;

      @Autowired
      IArtistService artistService;

      @Autowired
      IPlaylistService playlistService;

      @Autowired
      IArtistRepository artistRepository;


      @GetMapping
      public ResponseEntity<Iterable<Song>> listSongs() {
            Iterable<Song> songs = songService.findAll();
            if (songs == null) {
                  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(songs, HttpStatus.OK);
      }

      @GetMapping("/{id}")
      public ResponseEntity<Song> getSongById(@PathVariable long id) {
            return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
      }

      @PostMapping("/create")
      public ResponseEntity<Song> createSong(@RequestBody Song song) {
            Song song1 = song;
            songService.save(song);
            return new ResponseEntity<>(song, HttpStatus.CREATED);
      }

      @PutMapping("/update/{id}")
      public ResponseEntity<Song> updateSongInfo(@PathVariable long id, @RequestBody Song song) {
            Song currentSong = songService.findById(id);
            if (currentSong == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentSong.setName(song.getName());
            currentSong.setDescription(song.getDescription());
            currentSong.setCover_art_url(song.getCover_art_url());
            currentSong.setArtist(song.getArtist());
            currentSong.setDate(song.getDate());
            currentSong.setGenre(song.getGenre());
            currentSong.setPlays(song.getPlays());
            currentSong.setLikes(song.getLikes());

            songService.save(currentSong);
            return new ResponseEntity<>(currentSong, HttpStatus.OK);
      }

      @DeleteMapping("/delete/{id}")
      public ResponseEntity<Song> deleteSong(@PathVariable("id") long id) {
            Song song = songService.findById(id);
            if (song == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            songService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/plays/desc")
      public ResponseEntity<Iterable<Song>> songOrderByPlaysDesc() {
            Iterable<Song> songPlays = songRepository.findByOrderByPlaysDesc();
            return new ResponseEntity<>(songPlays, HttpStatus.OK);
      }

      @GetMapping("/likes/desc")
      public ResponseEntity<Iterable<Song>> songOrderByLikesDesc() {
            Iterable<Song> songLikes = songRepository.findByOrderByLikesDesc();
            return new ResponseEntity<>(songLikes, HttpStatus.OK);
      }

      @GetMapping("/date/desc")
      public ResponseEntity<Iterable<Song>> songOrderByDateDesc() {
            Iterable<Song> songDate = songRepository.findByOrderByDateDesc();
            return new ResponseEntity<>(songDate, HttpStatus.OK);
      }

      @GetMapping("/search/{name}")
      public ResponseEntity<Iterable<Song>> findSongByNameContaining(@PathVariable String name) {
            return new ResponseEntity<>(songService.findSongByName(name), HttpStatus.OK);
      }

      @GetMapping("/listByUid/{id}")
      public ResponseEntity<Iterable<Song>> findSongsByUserId(@PathVariable Long id) {
            User user = userService.findUserById(id);
            Iterable<Song> listSongsByUid = songRepository.findAllByUser(user);
            return new ResponseEntity<>(listSongsByUid, HttpStatus.OK);
      }

      @GetMapping("/listByArtist/{id}")
      public ResponseEntity<Iterable<Song>> findAllSongByArtist(@PathVariable Long id) {
            Artist artist = artistService.findArtistById(id);
            Iterable<Song> listSongsByAid = songRepository.findAllByArtist(artist);
            return new ResponseEntity<>(listSongsByAid, HttpStatus.OK);
      }


      @GetMapping("/allArtist")
      public ResponseEntity<Iterable<Artist>> listArtists() {
            Iterable<Artist> artists = artistService.findAll();
            if (artists == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(artists, HttpStatus.OK);
      }

      @GetMapping("/search-artist/{name}")
      public ResponseEntity<Iterable<Artist>> findArtistByNameContaining(@PathVariable String name) {
            return new ResponseEntity<>(artistRepository.findAllByNameContaining(name), HttpStatus.OK);
      }
}
