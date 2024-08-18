package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/players/paginated")
    private List<Players> getAllPlayers(Pageable pageable) {
        Page<Players> page = playersRepository.findAll(
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(Sort.by(Sort.Direction.ASC, "playerID"))));
        return page.getContent();      
    }

    @GetMapping("/players/{playerID}")
    private Optional<Players> getPlayer(@PathVariable String playerID) {
        return playersRepository.findById(playerID);
    }

    @PostMapping("/players")
    private ResponseEntity<Players> addPlayer(@RequestBody Players player) throws URISyntaxException {
        Optional<Players> playerExists = playersRepository.findById(player.getPlayerID());
        if (!playerExists.isPresent()) {
            playersRepository.save(player);
            URI uri = new URI("api/players/" + player.getPlayerID());
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
