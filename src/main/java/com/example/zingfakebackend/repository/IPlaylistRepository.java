package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Playlist;
import com.example.zingfakebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {
      Iterable<Playlist> findAllByNameContaining(String name);
      Iterable<Playlist> findAllByUser(User user);
}
