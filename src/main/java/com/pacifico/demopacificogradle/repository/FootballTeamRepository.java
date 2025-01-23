package com.pacifico.demopacificogradle.repository;

/**
 * @author josediaz
 **/


import com.pacifico.demopacificogradle.model.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {
}