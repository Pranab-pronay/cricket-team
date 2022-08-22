package com.example.cricketteam.datasource.schemas;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}
