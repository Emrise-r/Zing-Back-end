package com.example.zingfakebackend.controller;


import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.model.PlaylistSong;
import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.repository.IPlayListSongRepository;
import com.example.zingfakebackend.service.song.IPlaylistService;
import com.example.zingfakebackend.service.song.IPlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlist-song")
public class PlaylistSongController {
    @Autowired
    IPlayListSongRepository iPlayListSongRepository;

    @Autowired
    IPlaylistSongService playlistSongService;

    @Autowired
    IPlaylistService playlistService;

    @GetMapping("/playlist/{playListId}")
    public ResponseEntity<Iterable<PlaylistSong>> getAllPlaylistSong(@PathVariable Long playListId) {
        Iterable<PlaylistSong> playListSongs;
        Playlist playlist = playlistService.findById(playListId);
        playListSongs = iPlayListSongRepository.findAllByPlaylist(playlist);
        return new ResponseEntity<>(playListSongs, HttpStatus.OK);
    }

    @PostMapping("/add-song")
    public ResponseEntity<PlaylistSong> addSong(@RequestBody PlaylistSong playlistSong) {
        this.playlistSongService.save(playlistSong);
        return new ResponseEntity<PlaylistSong>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{playListSongId}")
    public ResponseEntity<PlaylistSong> deletePlaylistSong(@PathVariable Long playListSongId) {
        this.playlistSongService.remove(playListSongId);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
