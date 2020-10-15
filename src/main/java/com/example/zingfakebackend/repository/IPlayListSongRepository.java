package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.model.PlaylistSong;
import com.example.zingfakebackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayListSongRepository extends JpaRepository<PlaylistSong, Long> {
    Iterable<PlaylistSong> findAllByPlaylist(Playlist playlist);
}
