package com.example.cricketteam.datasource.repository;

import com.example.cricketteam.datasource.schemas.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {



}
