package com.example.cricketteam.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDto {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    public LocalDateTime initTime;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    public LocalDateTime finishTime;


}
