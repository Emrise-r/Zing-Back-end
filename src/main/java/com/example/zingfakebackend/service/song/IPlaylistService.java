package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Playlist;

public interface IPlaylistService {
      Iterable<Playlist> findAll();
      void save(Playlist playlist);
      void remove(Long id);
      Playlist findById(Long id);
      Iterable<Playlist> findByName(String name);
}
