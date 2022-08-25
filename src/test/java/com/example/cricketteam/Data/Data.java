package com.example.cricketteam.Data;

import com.example.cricketteam.Dto.AssignTaskDto;
import com.example.cricketteam.Dto.PlayerDto;
import com.example.cricketteam.Dto.ScheduleDto;
import com.example.cricketteam.Dto.TaskDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static String newPlayerBody() throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(new PlayerDto().setName("Pranab Datta"));
    }

    public static String newTaskBody() throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(new TaskDto().setTitle("Batting Practise"));

    }

    public static String newAssignTask(String taskTitle, int player) throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(new AssignTaskDto().setTaskTitle(taskTitle)
                .setPlayers(new ArrayList<>(List.of(player, 5)))
                .setInitTime(LocalDateTime.of(2022, 8, 26, 12, 11))
                .setFinishTime(LocalDateTime.of(2022, 8, 26, 20, 10))
        );
    }
    public static String newSchedule() throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(new ScheduleDto()
                .setInitTime(LocalDateTime.of(2022, 8, 26, 12, 10))
                .setFinishTime(LocalDateTime.of(2022, 8, 27, 20, 11))
        );
    }

    public static <T> T asObject(final String json, Class<T> type) throws  JsonProcessingException {
        return getObjectMapper().readValue(json, type);
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .registerModule(new Jdk8Module());
    }
}
