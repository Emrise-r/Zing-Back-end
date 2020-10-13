package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Artist;

public interface IArtistService {
      Iterable<Artist> findAll();
      void save(Artist artist);
      void delete(Long id);
      Artist findById(Long id);
      Artist findArtistById(Long id);
}
