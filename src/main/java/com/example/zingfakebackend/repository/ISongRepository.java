package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Artist;
import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ISongRepository extends JpaRepository<Song, Long> {
      Iterable<Song> findByOrderByPlaysDesc();
      Iterable<Song> findByOrderByLikesDesc();
      Iterable<Song> findByOrderByDateDesc();
      Iterable<Song> findAllByNameContaining(String name);
      Iterable<Song> findAllByUser(User user);
      Iterable<Song> findAllByArtist(Artist artist);
}
