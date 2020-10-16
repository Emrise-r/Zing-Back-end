package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistRepository extends JpaRepository<Artist, Long> {
      Iterable<Artist> findAllByNameContaining(String name);
}
