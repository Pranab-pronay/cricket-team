package com.example.cricketteam.datasource.schemas;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity(name = "Task")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

}
