package com.example.tourdefrancebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

  @OneToMany
  @JoinColumn(name = "team_id")
/*  @JsonIgnore*/
  @JsonBackReference
  private Set<Rider> riders = new HashSet<>();

  public int getTeamId() {
    return teamId;
  }

  public void setTeamId(int teamId) {
    this.teamId = teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public Set<Rider> getRiders() {
    return riders;
  }

  public void setRiders(Set<Rider> riders) {
    this.riders = riders;
  }


  @Override
  public String toString() {
    return "Team{" +
        "teamId=" + teamId +
        ", teamName='" + teamName + '\'' +
        ", riders=" + riders +
        '}';
  }
}