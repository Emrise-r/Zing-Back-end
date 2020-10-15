package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.model.User;
import com.example.zingfakebackend.repository.IPlaylistRepository;
import com.example.zingfakebackend.service.song.IPlaylistService;
import com.example.zingfakebackend.service.song.ISongService;
import com.example.zingfakebackend.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlaylistController {
      @Autowired
      IPlaylistService playlistService;

      @Autowired
      IUserService userService;

      @Autowired
      IPlaylistRepository playlistRepository;

      @Autowired
      ISongService songService;

      @GetMapping
      public ResponseEntity<Iterable<Playlist>> getAllPlaylists() {
            Iterable<Playlist> playlists = playlistService.findAll();
            return new ResponseEntity<>(playlists, HttpStatus.OK);
      }

      @GetMapping("/{id}")
      public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
            return new ResponseEntity<>(playlistService.findById(id), HttpStatus.OK);
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

      @GetMapping("/listByUid/{id}")
      public ResponseEntity<Iterable<Playlist>> findPlaylistsByUserId(@PathVariable Long id) {
            User user = userService.findUserById(id);
            Iterable<Playlist> listPlaylistsByUid = playlistRepository.findAllByUser(user);
            return new ResponseEntity<>(listPlaylistsByUid, HttpStatus.OK);
      }

      @PostMapping("/{id}/addSong")
      public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long id, @RequestBody List<Long> songsId) {
            Playlist playlist = playlistService.findById(id);
            List<Song> songs = playlist.getPl_songs();
            for (Long songId : songsId) {
                  songs.add(songService.findById(songId));
            }
            playlist.setPl_songs(songs);
            playlistService.save(playlist);
            return new ResponseEntity<>(playlist, HttpStatus.OK);
      }

      @DeleteMapping("/{playlistId}/{songId}/delete")
      public ResponseEntity<?> removeSongFromPlaylist(@PathVariable Long playlistId, @PathVariable Long songId){
            Playlist playlist = playlistService.findById(playlistId);
            playlist.getPl_songs().remove(songService.findById(songId));
            playlistService.save(playlist);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/{id}/songs")
      public ResponseEntity<List<Song>> getAllSongFromPlaylist(@PathVariable Long id){
            Playlist playlist = playlistService.findById(id);
            List<Song> songs = playlist.getPl_songs();
            return new ResponseEntity<>(songs, HttpStatus.OK);
      }
}
