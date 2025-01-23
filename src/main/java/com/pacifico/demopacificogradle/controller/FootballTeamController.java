package com.pacifico.demopacificogradle.controller;

import com.pacifico.demopacificogradle.service.FootballTeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author josediaz
 **/
@RestController
public class FootballTeamController {

  private final FootballTeamService service;

  public FootballTeamController(FootballTeamService service) {
    this.service = service;
  }

  @GetMapping("/teams")
  public Flux<String> getFootballTeams() {
    return service.getAllTeamNames();
  }
}