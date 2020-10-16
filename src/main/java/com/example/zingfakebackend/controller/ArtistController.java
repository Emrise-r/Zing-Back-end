package com.example.zingfakebackend.controller;

import com.example.zingfakebackend.model.Artist;
import com.example.zingfakebackend.repository.IArtistRepository;
import com.example.zingfakebackend.service.song.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/artist")
public class ArtistController {
      @Autowired
      IArtistService artistService;

      @Autowired
      IArtistRepository artistRepository;

      @PostMapping("/create-artist")
      public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
            artistService.save(artist);
            return new ResponseEntity<>(artist, HttpStatus.CREATED);
      }

      @PutMapping("/update-artist/{id}")
      public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
            Artist currentArtist = artistService.findById(id);
            if (currentArtist == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentArtist.setName(artist.getName());
            return new ResponseEntity<>(currentArtist, HttpStatus.OK);
      }

      @DeleteMapping("/delete-artist/{id}")
      public ResponseEntity<Artist> deleteArtist(@PathVariable Long id) {
            Artist artist = artistService.findArtistById(id);
            if (artist == null) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            artistService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
      }

//      @GetMapping("/search-artist/{name}")
//      public ResponseEntity<Iterable<Artist>> findArtistByNameContaining(@PathVariable String name) {
//            return new ResponseEntity<>(artistRepository.findAllByNameContaining(name), HttpStatus.OK);
//      }
}
