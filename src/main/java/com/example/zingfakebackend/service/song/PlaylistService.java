package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.repository.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService implements IPlaylistService {

      @Autowired
      private IPlaylistRepository playlistRepository;

      @Override
      public Iterable<Playlist> findAll() {
            return playlistRepository.findAll() ;
      }

      @Override
      public void save(Playlist playlist) {
            playlistRepository.save(playlist);
      }

      @Override
      public void remove(Long id) {
            playlistRepository.deleteById(id);
      }

      @Override
      public Playlist findById(Long id) {
            return playlistRepository.findById(id).orElse(null);
      }

      @Override
      public Iterable<Playlist> findByName(String name) {
            return playlistRepository.findAllByNameContaining(name);
      }
}
