package com.example.cricketteam.Dto;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class PlayerDto {

    @NotNull(message = "Name Not Found Or Invalid")
    @NotBlank(message = "Name Not Found Or Invalid")
    private String name;

    private int id;

    private String responseMessage;
}
