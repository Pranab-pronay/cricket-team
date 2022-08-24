package com.example.cricketteam.datasource.schemas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Assign_Task")
@Getter
@Setter
@Accessors(chain = true)

public class AssignTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="player_id")
    @JsonBackReference
    private Player player;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_init_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime initTime;

    @Column(name = "task_finish_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime finishTime;



}
