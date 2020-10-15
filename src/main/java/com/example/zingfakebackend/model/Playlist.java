package com.example.zingfakebackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Playlist {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String name;

      @ManyToOne
      @JoinColumn(name = "user_id")
      private User user;

      @ManyToMany(cascade = CascadeType.ALL)
      @JoinTable(name = "song_playlist",
              joinColumns = {@JoinColumn(name = "playlist_id")},
              inverseJoinColumns = {@JoinColumn(name = "song_id")})
      private List<Song> pl_songs;

      public List<Song> getPl_songs() {
            return pl_songs;
      }

      public void setPl_songs(List<Song> pl_songs) {
            this.pl_songs = pl_songs;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }
}