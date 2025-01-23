package com.pacifico.demopacificogradle.service;

import com.pacifico.demopacificogradle.model.FootballTeam;
import com.pacifico.demopacificogradle.repository.FootballTeamRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author josediaz
 **/
@Service
public class FootballTeamService {

  private final FootballTeamRepository repository;

  public FootballTeamService(FootballTeamRepository repository) {
    this.repository = repository;
  }

  @PostConstruct
  public void loadInitialData() {
    if (repository.count() == 0) {
      List<FootballTeam> teams = List.of(
          new FootballTeam(null, "Barcelona"),
          new FootballTeam(null, "Real Madrid"),
          new FootballTeam(null, "Manchester United"),
          new FootballTeam(null, "Liverpool"),
          new FootballTeam(null, "Bayern Munich"),
          new FootballTeam(null, "Juventus"),
          new FootballTeam(null, "Paris Saint-Germain"),
          new FootballTeam(null, "AC Milan")
      );
      repository.saveAll(teams);
    }
  }

  public Flux<String> getAllTeamNames() {
    return Flux.fromIterable(repository.findAll())
        .map(FootballTeam::getName);
  }
}