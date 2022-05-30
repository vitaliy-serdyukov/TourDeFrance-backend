package com.example.tourdefrancebackend.model;

import javax.persistence.*;

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

  public int getRiderId() {
    return riderId;
  }

  public void setRiderId(int riderId) {
    this.riderId = riderId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getRiderTime() {
    return riderTime;
  }

  public void setRiderTime(int riderTime) {
    this.riderTime = riderTime;
  }

  public int getMountainPoints() {
    return mountainPoints;
  }

  public void setMountainPoints(int mountainPoints) {
    this.mountainPoints = mountainPoints;
  }

  public int getSprintPoints() {
    return sprintPoints;
  }

  public void setSprintPoints(int sprintPoints) {
    this.sprintPoints = sprintPoints;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  @Override
  public String toString() {
    return "Rider{" +
        "riderId=" + riderId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", riderTime=" + riderTime +
        ", mountainPoints=" + mountainPoints +
        ", sprintPoints=" + sprintPoints +
        ", team=" + team +
        '}';
  }
}