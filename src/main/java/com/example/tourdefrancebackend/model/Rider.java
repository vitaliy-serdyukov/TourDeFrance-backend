package com.example.tourdefrancebackend.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Rider {

  @Id
  @Column(name = "rider_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int riderId;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private int age;

  @Column(nullable = false)
  private int riderTime;

  @Column(nullable = false)
  private int mountainPoints;

  @Column(nullable = false)
  private int sprintPoints;


  @ManyToOne
  @JoinColumn(name = "team_id", nullable = false)
  private Team team;
}
