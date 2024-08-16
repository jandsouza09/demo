package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Players;
import com.example.demo.model.PlayersRepository;

@RestController
@RequestMapping("/api")
public class PlayersController {

    @Autowired
    private PlayersRepository playersRepository;
    
    @GetMapping("/players")
    private List<Players> getAllPlayers() {
        return playersRepository.findAll();       
    }

    @GetMapping("/players/{playerID}")
    private Optional<Players> getPlayer(@PathVariable String playerID) {
        return playersRepository.findById(playerID);
    }
}
