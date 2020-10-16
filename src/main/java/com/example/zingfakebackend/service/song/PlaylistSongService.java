package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.PlaylistSong;
import com.example.zingfakebackend.repository.IPlayListSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistSongService implements IPlaylistSongService{

    @Autowired
    IPlayListSongRepository iPlayListSongRepository;

    @Override
    public Iterable<PlaylistSong> findAll() {
        return iPlayListSongRepository.findAll();
    }

    @Override
    public void save(PlaylistSong playlist_song) {
        iPlayListSongRepository.save(playlist_song);
    }

    @Override
    public void remove(Long id) {
        iPlayListSongRepository.deleteById(id);
    }

    @Override
    public PlaylistSong findById(Long id) {
        return iPlayListSongRepository.findById(id).orElse(null);
    }
}
