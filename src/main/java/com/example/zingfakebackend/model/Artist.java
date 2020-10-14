package com.example.zingfakebackend.model;

import javax.persistence.*;

@Entity
@Table
public class Artist {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String name;

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

      public Artist(Long id, String name) {
            this.id = id;
            this.name = name;
      }

      public Artist(String name) {
            this.name = name;
      }

      public Artist() {
      }
}
