package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.LoadDataService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private LoadDataService loadDataService;

    @Override
    public void run(String... args) throws Exception {
        loadDataService.loadPlayersFromCsv("src/main/resources/Player.csv");
    }
}
