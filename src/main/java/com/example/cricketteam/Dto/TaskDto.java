package com.example.cricketteam.Dto;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Accessors(chain = true)
public class TaskDto {

    @NotNull(message = "Task Title Not Found Or Invalid")
    @NotBlank(message = "Task Title Not Found Or Invalid")
    private String title;

    private String responseMessage;

}
