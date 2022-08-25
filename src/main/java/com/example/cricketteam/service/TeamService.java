package com.example.cricketteam.service;

import com.example.cricketteam.Dto.*;
import com.example.cricketteam.datasource.repository.AssignTaskRepository;
import com.example.cricketteam.datasource.repository.PlayerRepository;
import com.example.cricketteam.datasource.repository.TaskRepository;
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
public class TeamService {
    private final PlayerRepository playerRepository;
    private final TaskRepository taskRepository;
    private final AssignTaskRepository assignTaskRepository;

    public PlayerDto addPlayer(PlayerDto playerDto) {
        Player player = new Player().setName(playerDto.getName());
        playerRepository.save(player);
        playerDto.setId(player.getId()).setResponseMessage("Successfully Added");
        return playerDto;
    }

    public TaskDto addTask(TaskDto taskDto) {
        Task task = taskRepository.findFirstByTitle(taskDto.getTitle());
        if (task!= null)
            return taskDto.setResponseMessage("Task Already Exist");
        Task newTask= new Task().setTitle(taskDto.getTitle());
        taskRepository.save(newTask);
        taskDto.setResponseMessage("Successfully Added");
        return taskDto;
    }

    public String assignTask(AssignTaskDto assignTaskDto) {
        Task task = taskRepository.findFirstByTitle(assignTaskDto.getTaskTitle());
        if (task == null)
            throw new ObjectNotFoundException("Invalid Task Title");
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

    public List<AssignTask> getAssignedTasks(int playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty())
            throw new ObjectNotFoundException("Player Not Found");
        return player.get().getAssignTaskList();
    }

    public  List<ScheduledTaskResponse> getAllAssignedTasksByTimeRange(ScheduleDto scheduleDto) {
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

}
