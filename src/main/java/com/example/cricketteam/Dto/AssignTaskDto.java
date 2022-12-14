package com.example.cricketteam.Dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Accessors(chain = true)
public class AssignTaskDto extends ScheduleDto {

    @NotNull(message = "Task Title Not Found Or Invalid")
    @NotBlank(message = "Task Title Not Found Or Invalid")
    public String taskTitle;

    @NotNull
    public List<Integer> players;



}
