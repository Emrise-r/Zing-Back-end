package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Artist;
import com.example.zingfakebackend.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService implements IArtistService{

      @Autowired
      private IArtistRepository artistRepository;

      @Override
      public Iterable<Artist> findAll() {
            return artistRepository.findAll();
      }

      @Override
      public void save(Artist artist) {
            artistRepository.save(artist);
      }

      @Override
      public void delete(Long id) {
            artistRepository.deleteById(id);
      }

      @Override
      public Artist findById(Long id) {
            return artistRepository.findById(id).orElse(null);
      }

      @Override
      public Artist findArtistById(Long id) {
            return artistRepository.findById(id).get();
      }
}
