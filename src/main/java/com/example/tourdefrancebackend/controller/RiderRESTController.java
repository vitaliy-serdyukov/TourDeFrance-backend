package com.example.tourdefrancebackend.controller;

import com.example.tourdefrancebackend.model.Rider;
import com.example.tourdefrancebackend.model.Team;
import com.example.tourdefrancebackend.repository.RiderRepository;
import com.example.tourdefrancebackend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class RiderRESTController {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;


  @GetMapping("/riders")
  public List<Rider> getAllriders() {
    return riderRepository.findAll();
  }


  @GetMapping("/show/riderByTeam/{id}")
  public List<Rider> findRiderByTeam(@PathVariable int id) {
    Optional<Team> optionalTeam = teamRepository.findById(id);
    if (optionalTeam.isPresent()) {
      Team team = optionalTeam.get();
      return riderRepository.findRiderByTeam(team);
    } else {
      return null;
    }
  }

  @PostMapping("/create/rider")
  @ResponseStatus(HttpStatus.CREATED)
  public Rider createRider(@RequestBody Rider rider) {
    System.out.println(rider);
    return riderRepository.save(rider);
  }

  @PutMapping("/update/rider/{id}")
  public ResponseEntity<Rider> updateRider(@PathVariable int id, @RequestBody Rider rider) {
    Optional<Rider> optRider = riderRepository.findById(id);
    if (optRider.isPresent()) {
      riderRepository.save(rider);
      return new ResponseEntity<>(rider, HttpStatus.OK);
    } else {
      Rider notfoundRider = new Rider();
      notfoundRider.setFirstName("Rider with id= " + id + " has not been found");
            return new ResponseEntity<>(notfoundRider, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/rider/{id}")
  public ResponseEntity<String> deleteRider(@PathVariable int id) {
    try {
      riderRepository.deleteById(id);
      return new ResponseEntity<>("Slettet id=" + id, HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>("Rider with id= " + id + " couldn't be deleted", HttpStatus.NOT_FOUND);
    }
  }
}