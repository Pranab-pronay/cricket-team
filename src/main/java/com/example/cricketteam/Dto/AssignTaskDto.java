package com.example.cricketteam.Dto;

import lombok.Data;

import java.util.List;

@Data
public class AssignTaskDto extends ScheduleDto {

    public String taskTitle;
    public List<Integer> players;



}
