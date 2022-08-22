package com.example.cricketteam.service;

import com.example.cricketteam.datasource.repository.TestDataRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestService {
    private final TestDataRepsitory testDataRepsitory;

    public Object getAll(){
        return testDataRepsitory.findAll();
    }

}
