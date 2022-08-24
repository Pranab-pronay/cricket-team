package com.example.cricketteam.datasource.repository;

import com.example.cricketteam.datasource.schemas.AssignTask;
import com.example.cricketteam.datasource.schemas.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AssignTaskRepository extends JpaRepository<AssignTask, Integer> {

    List<AssignTask> findAllByPlayer(Player player);

    List<AssignTask> findAllByInitTimeAfterAndFinishTimeBefore(LocalDateTime initTime, LocalDateTime finishTime);


}
