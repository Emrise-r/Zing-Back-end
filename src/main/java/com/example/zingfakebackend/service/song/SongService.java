package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{

      @Autowired
      ISongRepository songRepository;

      @Override
      public Iterable<Song> findAll() {
            return songRepository.findAll();
      }

      @Override
      public Song findById(long id) {
            return songRepository.findById(id).orElse(null);
      }

      @Override
      public void save(Song song) {
            songRepository.save(song);
      }

      @Override
      public void remove(long id) {
            songRepository.deleteById(id);
      }

      @Override
      public Iterable<Song> findSongByName(String name) {
            return songRepository.findAllByNameContaining(name);
      }
}
