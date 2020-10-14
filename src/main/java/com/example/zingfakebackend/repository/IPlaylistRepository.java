package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {
      Iterable<Playlist> findAllByNameContaining(String name);
}
