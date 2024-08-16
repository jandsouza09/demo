package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Players, String> {
    
}
