package com.example.tourdefrancebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

  @Id
  @Column(name = "team_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int teamId;

  @Column(nullable = false)
  private String teamName;

  @Column(nullable = false)
  private String country;

  @OneToMany
  @JoinColumn(name = "team_id")
  @JsonIgnore
  private Set<Rider> riders = new HashSet<>();

}
