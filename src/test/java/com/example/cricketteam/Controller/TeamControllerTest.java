package com.example.cricketteam.Controller;

import com.example.cricketteam.Dto.PlayerDto;
import com.example.cricketteam.Dto.TaskDto;
import com.example.cricketteam.controller.TeamController;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.cricketteam.Data.Data.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamControllerTest {
    @Autowired
    private TeamController teamController;
    @Autowired private MockMvc mockMvc;
    private static int playerId;
    private static String taskTitle;

    @Test
    @Order(0)
    public void contextLoads() {
        assertThat(teamController).isNotNull();
    }

    @Test
    @Order(1)
    void testAddPlayer() throws Exception {
        String rs = mockMvc.perform(post("/player/add").accept(MediaType.APPLICATION_JSON)
                        .content(newPlayerBody())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseMessage").exists())
                .andExpect(jsonPath("$.responseMessage").value(CoreMatchers.is("Successfully Added")))
                .andReturn().getResponse().getContentAsString();

        PlayerDto playerDto = asObject(rs, PlayerDto.class);
        playerId = playerDto.getId();
        System.out.println("Added Player With Id "+playerId);
    }

    @Test
    @Order(2)
    void testAddTask() throws Exception {
        String rs = mockMvc.perform(post("/task/add").accept(MediaType.APPLICATION_JSON)
                        .content(newTaskBody())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseMessage").exists())
                .andExpect(jsonPath("$.responseMessage").value(CoreMatchers.is("Successfully Added")))
                .andReturn().getResponse().getContentAsString();

        TaskDto taskDto = asObject(rs, TaskDto.class);
        taskTitle = taskDto.getTitle();
        System.out.println("Added Task With Title "+taskTitle);

    }

    @Test
    @Order(3)
    void testAssignTask() throws Exception {
        mockMvc.perform(post("/task/assign").accept(MediaType.APPLICATION_JSON)
                        .content(newAssignTask(taskTitle, playerId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void testGetAssignTasksofPlayer() throws Exception {
        mockMvc.perform(get("/player/getAssignedTasks/" + playerId).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @Order(5)
    void testGetAllAssignedTasksByTimeRange() throws Exception {
        mockMvc.perform(post("/getAllAssignedTasksByTimeRange").accept(MediaType.APPLICATION_JSON)
                        .content(newSchedule())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
