package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.service.song.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlaylistController {
      @Autowired
      IPlaylistService playlistService;

      @GetMapping
      public ResponseEntity<Iterable<Playlist>> getAllPlaylists() {
            Iterable<Playlist> playlists = playlistService.findAll();
            return new ResponseEntity<>(playlists, HttpStatus.OK);
      }

      @PostMapping("/create-playlist")
      public ResponseEntity<Playlist> createNewPlaylist(@RequestBody Playlist playlist) {
            playlistService.save(playlist);
            return new ResponseEntity<>(playlist, HttpStatus.CREATED);
      }

      @PutMapping("/update-playlist/{id}")
      public ResponseEntity<Playlist> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
            Playlist currentPlaylist = playlistService.findById(id);
            if (currentPlaylist == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentPlaylist.setName(playlist.getName());
            playlistService.save(currentPlaylist);
            return new ResponseEntity<>(currentPlaylist, HttpStatus.OK);
      }

      @DeleteMapping("/delete-playlist/{id}")
      public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id) {
            Playlist playlist = playlistService.findById(id);
            if (playlist == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            playlistService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/search-playlist/{name}")
      public ResponseEntity<Iterable<Playlist>> findPlaylistByNameContaining(@PathVariable String name) {
            return new ResponseEntity<>(playlistService.findByName(name), HttpStatus.OK);
      }
}
