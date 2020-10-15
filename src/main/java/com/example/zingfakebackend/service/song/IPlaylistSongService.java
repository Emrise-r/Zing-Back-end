package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.PlaylistSong;

public interface IPlaylistSongService {
    Iterable<PlaylistSong> findAll();
    void save(PlaylistSong playlist_song);
    void remove(Long id);
    PlaylistSong findById(Long id);
//    Iterable<Playlist_Song> findByName(String name);
}
