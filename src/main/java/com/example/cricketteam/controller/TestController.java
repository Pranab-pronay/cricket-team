package com.example.cricketteam.controller;

import com.example.cricketteam.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class TestController {
    private final TestService testService;

    @GetMapping("/test/getAll")
    public Object getAll() {
        return testService.getAll();
    }


}
