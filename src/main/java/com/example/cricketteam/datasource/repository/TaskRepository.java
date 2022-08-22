package com.example.cricketteam.datasource.repository;

import com.example.cricketteam.datasource.schemas.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {



}
