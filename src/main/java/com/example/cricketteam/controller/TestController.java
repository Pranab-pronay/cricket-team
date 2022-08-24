package com.example.cricketteam.controller;

import com.example.cricketteam.Dto.AssignTaskDto;
import com.example.cricketteam.Dto.ScheduleDto;
import com.example.cricketteam.datasource.schemas.Player;
import com.example.cricketteam.datasource.schemas.Task;
import com.example.cricketteam.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class TestController {
    private final TestService testService;

    @GetMapping("/test/getAll")
    public Object getAll() {
        return testService.getAll();
    }

    @PostMapping("/player/add")
    public Object addPlayer(@RequestBody Player player) {
        return testService.addPlayer(player);
    }

    @PostMapping("/task/add")
    public Object addTask(@RequestBody Task task) {
        return testService.addTask(task);
    }

    @PostMapping("/task/assign")
    public Object assignTask(@RequestBody AssignTaskDto assignTaskDto) {
        return testService.assignTask(assignTaskDto);
    }

    @GetMapping("/player/getAssignedTasks/{playerId}")
    public Object getAssignedTasks(@PathVariable("playerId") final int playerId) {
        return testService.getAssignedTasks(playerId);
    }
    @PostMapping("/getAllAssignedTasksByTimeRange")
    public Object getAllAssignedTasksByTimeRange(@RequestBody ScheduleDto scheduleDto) {
        return testService.getAllAssignedTasksByTimeRange(scheduleDto);
    }

    @GetMapping("/task/getAssignedTasks")
    public Object getAllAssignedTasks() {
        return testService.getAllAssignedTasks();
    }
}
