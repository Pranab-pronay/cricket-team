package com.example.cricketteam.datasource.schemas;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

}
