package com.example.cricketteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class CricketTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketTeamApplication.class, args);
	}

}
