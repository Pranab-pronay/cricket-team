package com.example.cricketteam.Dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ScheduledTaskResponse{

    public String taskTitle;
    public String playerName;
    public LocalDateTime initTime;
    public LocalDateTime finishTime;



}
