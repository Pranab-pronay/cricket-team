package com.example.cricketteam.datasource.schemas;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "test_data")
public class TestData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "occupation")
    private String occupation;
}
