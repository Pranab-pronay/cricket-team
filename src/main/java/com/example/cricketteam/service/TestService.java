package com.example.cricketteam.service;

import com.example.cricketteam.Dto.AssignTaskDto;
import com.example.cricketteam.Dto.ScheduleDto;
import com.example.cricketteam.Dto.ScheduledTaskResponse;
import com.example.cricketteam.datasource.repository.AssignTaskRepository;
import com.example.cricketteam.datasource.repository.PlayerRepository;
import com.example.cricketteam.datasource.repository.TaskRepository;
import com.example.cricketteam.datasource.repository.TestDataRepsitory;
import com.example.cricketteam.datasource.schemas.AssignTask;
import com.example.cricketteam.datasource.schemas.Player;
import com.example.cricketteam.datasource.schemas.Task;
import com.example.cricketteam.exeptionHandler.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestService {
    private final TestDataRepsitory testDataRepsitory;
    private final PlayerRepository playerRepository;
    private final TaskRepository taskRepository;
    private final AssignTaskRepository assignTaskRepository;

    public Object getAll() {
        return testDataRepsitory.findAll();
    }

    public Object addPlayer(Player player) {
        playerRepository.save(player);
        return "successfully added" + player;
    }

    public Object addTask(Task task) {
        taskRepository.save(task);
        return "successfully added " + task.getTitle();
    }

    public Object assignTask(AssignTaskDto assignTaskDto) {
        Task task = taskRepository.findByTitle(assignTaskDto.getTaskTitle());
        if (task == null)
            throw new ObjectNotFoundException("Invalid Task!");
        List<Player> players = playerRepository.findByIdIn(assignTaskDto.getPlayers());
        for (Player player : players) {
            AssignTask assignTask = new AssignTask()
                    .setTaskTitle(task.getTitle())
                    .setPlayer(player)
                    .setInitTime(assignTaskDto.getInitTime())
                    .setFinishTime(assignTaskDto.getFinishTime());
            assignTaskRepository.save(assignTask);
        }
        return "Task Assigned";
    }

    public Object getAssignedTasks(int playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty())
            throw new ObjectNotFoundException("Player Not Found");
        return player.get().getAssignTaskList();
    }

    public Object getAllAssignedTasksByTimeRange(ScheduleDto scheduleDto) {
        List<AssignTask> assignTaskList= assignTaskRepository.findAllByInitTimeAfterAndFinishTimeBefore(scheduleDto.getInitTime(), scheduleDto.getFinishTime());
        List<ScheduledTaskResponse> scheduledTaskResponseList=new ArrayList<>();
        for(AssignTask assignTask: assignTaskList){
            ScheduledTaskResponse scheduledTaskResponse= new ScheduledTaskResponse()
                    .setTaskTitle(assignTask.getTaskTitle())
                    .setPlayerName(assignTask.getPlayer().getName())
                    .setInitTime(assignTask.getInitTime())
                    .setFinishTime(assignTask.getFinishTime());
            scheduledTaskResponseList.add(scheduledTaskResponse);

        }
        return scheduledTaskResponseList;
    }

    public List<AssignTask> getAllAssignedTasks() {
        return assignTaskRepository.findAll();
    }
}
