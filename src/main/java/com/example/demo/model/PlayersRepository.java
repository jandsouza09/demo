package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayersRepository extends JpaRepository<Players, String> {
    
    List<Players> findByBirthCity(@Param("birthCity") String birthCity);

    List<Players> findByBirthYear(@Param("birthYear") Integer birthYear);

    @Query("SELECT DISTINCT p.birthYear FROM Players p")
    List<Integer> findDistinctByBirthYear();
}
