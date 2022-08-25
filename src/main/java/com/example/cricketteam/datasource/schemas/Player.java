package com.example.cricketteam.datasource.schemas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;


@Entity(name = "Player")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="player")
    @JsonManagedReference
    private List<AssignTask> assignTaskList;



}
