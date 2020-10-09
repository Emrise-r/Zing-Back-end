package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Song;

public interface ISongService {

    Iterable<Song> findAll();

    Song findBySongId(Long id);

    void save(Song song);

    void remove(Long id);

}
