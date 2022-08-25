package com.example.cricketteam.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ScheduleDto {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    public LocalDateTime initTime;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    public LocalDateTime finishTime;


}
