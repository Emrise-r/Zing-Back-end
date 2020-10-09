package com.example.zingfakebackend.service.song;

import com.example.zingfakebackend.model.Song;
import com.example.zingfakebackend.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository isongRepository;


    @Override
    public Iterable<Song> findAll() {
        return isongRepository.findAll();
    }

    @Override
    public Song findBySongId(Long id) {
        return isongRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        isongRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        isongRepository.deleteById(id);
    }
}
