package com.example.cricketteam.datasource.repository;

import com.example.cricketteam.datasource.schemas.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByIdIn(List<Integer> idList);



}
