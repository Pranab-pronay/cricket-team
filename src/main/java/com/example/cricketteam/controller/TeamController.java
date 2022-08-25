package com.example.cricketteam.controller;

import com.example.cricketteam.Dto.*;
import com.example.cricketteam.datasource.schemas.AssignTask;
import com.example.cricketteam.datasource.schemas.Player;
import com.example.cricketteam.datasource.schemas.Task;
import com.example.cricketteam.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class TeamController {
    private final TeamService testService;

    @PostMapping("/player/add")
    public PlayerDto addPlayer(@RequestBody @Validated PlayerDto playerDto) {
        return testService.addPlayer(playerDto);
    }

    @PostMapping("/task/add")
    public TaskDto addTask(@RequestBody @Validated TaskDto taskDto) {
        return testService.addTask(taskDto);
    }

    @PostMapping("/task/assign")
    public String assignTask(@RequestBody  @Validated AssignTaskDto assignTaskDto) {
        return testService.assignTask(assignTaskDto);
    }

    @GetMapping("/player/getAssignedTasks/{playerId}")
    public List<AssignTask> getAssignedTasks(@PathVariable("playerId") final int playerId) {
        return testService.getAssignedTasks(playerId);
    }

    @PostMapping("/getAllAssignedTasksByTimeRange")
    public  List<ScheduledTaskResponse> getAllAssignedTasksByTimeRange(@RequestBody@Validated ScheduleDto scheduleDto) {
        return testService.getAllAssignedTasksByTimeRange(scheduleDto);
    }

}
