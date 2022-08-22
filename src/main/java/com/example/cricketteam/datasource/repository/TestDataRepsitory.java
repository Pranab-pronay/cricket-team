package com.example.cricketteam.datasource.repository;

import com.example.cricketteam.datasource.schemas.TestData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestDataRepsitory extends JpaRepository<TestData, Integer> {

    List<TestData> findAll();

    TestData findById(int id);


}
