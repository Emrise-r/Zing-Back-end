package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
      Iterable<Song> findByOrderByPlaysDesc();
      Iterable<Song> findByOrderByLikesDesc();
      Iterable<Song> findByOrderByDateDesc();
}
