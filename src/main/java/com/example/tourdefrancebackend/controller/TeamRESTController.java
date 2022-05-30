package com.example.tourdefrancebackend.controller;


import com.example.tourdefrancebackend.model.Team;
import com.example.tourdefrancebackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TeamRESTController {


  @Autowired
  TeamRepository teamRepository;

  @GetMapping("/teams")
  public List<Team> faaAllePartier() {
    return teamRepository.findAll();
  }


  @PostMapping("/create/team")
  @ResponseStatus(HttpStatus.CREATED)
  public Team createTeam(@RequestBody Team team) {
    System.out.println(team);
    return teamRepository.save(team);
  }

  @PutMapping("/update/team/{id}")
  public ResponseEntity<Team> updateTeam(
      @PathVariable int id, @RequestBody Team team) {
    team.setTeamId(id);
    Optional<Team> optionalTeam = teamRepository.findById(id);
    if (optionalTeam.isPresent()) {
      teamRepository.save(team);
      return new ResponseEntity<>(team, HttpStatus.OK);
    } else {
      Team notFound = new Team();
      notFound.setTeamName("Team with id= " + id + " has not been found");
      return new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND);
    }
  }


  @DeleteMapping("/delete/team/{id}")
  public ResponseEntity<String> deleteTeam(@PathVariable int id) {
    try {
      teamRepository.deleteById(id);
      return new ResponseEntity<>("delete id = " + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Could not id at all = " + id, HttpStatus.NOT_FOUND);
    }
  }
}