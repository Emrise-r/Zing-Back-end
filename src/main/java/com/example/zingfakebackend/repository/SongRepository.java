package com.example.zingfakebackend.repository;

import com.example.zingfakebackend.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
