package com.example.cricketteam.service;

import com.example.cricketteam.datasource.repository.PlayerRepository;
import com.example.cricketteam.datasource.repository.TaskRepository;
import com.example.cricketteam.datasource.repository.TestDataRepsitory;
import com.example.cricketteam.datasource.schemas.Player;
import com.example.cricketteam.datasource.schemas.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestService {
    private final TestDataRepsitory testDataRepsitory;
    private final PlayerRepository playerRepository;
    private final TaskRepository taskRepository;

    public Object getAll(){
        return testDataRepsitory.findAll();
    }
    public Object addPlayer(Player player){
        playerRepository.save(player);
        return "successfully added "+player.getName();
    }
    public Object addTask(Task task){
        taskRepository.save(task);
        return "successfully added "+task.getTitle();
    }

}
