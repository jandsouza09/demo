package com.example.demo.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
import java.time.LocalDate;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Players;
import com.example.demo.model.PlayersRepository;

@Service
public class LoadDataService {
    
    @Autowired
    private final PlayersRepository playersRepository;

    public LoadDataService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public Integer parseIntegerOrNull(String value) {
        if (value != null && value != "") {
            return Integer.parseInt(value);
        }
        else {
            return null;
        }
    }

    public LocalDate parseDateOrNull(String value) {
        if (value != null && value != "") {
            return LocalDate.parse(value);
        }
        else {
            return null;
        }
    }

    public void loadPlayersFromCsv(String filepath) throws IOException {
        List<Players> players = new ArrayList<>();

        try (Reader reader = new FileReader(filepath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
            for (CSVRecord record : csvParser) {
                Players player = new Players();
                player.setPlayerID(record.get("playerID"));
                player.setBirthYear(parseIntegerOrNull(record.get("birthYear")));
                player.setBirthMonth(parseIntegerOrNull(record.get("birthMonth")));
                player.setBirthDay(parseIntegerOrNull(record.get("birthDay")));
                player.setBirthCountry(record.get("birthCountry"));
                player.setBirthState(record.get("birthState"));
                player.setBirthCity(record.get("birthCity"));
                player.setDeathYear(parseIntegerOrNull(record.get("deathYear")));
                player.setDeathMonth(parseIntegerOrNull(record.get("deathMonth")));
                player.setDeathDay(parseIntegerOrNull(record.get("deathDay")));
                player.setDeathCountry(record.get("deathCountry"));
                player.setDeathState(record.get("deathState"));
                player.setDeathCity(record.get("deathCity"));
                player.setNameFirst(record.get("nameFirst"));
                player.setNameLast(record.get("nameLast"));
                player.setNameGiven(record.get("nameGiven"));
                player.setWeight(parseIntegerOrNull(record.get("weight")));
                player.setHeight(parseIntegerOrNull(record.get("height")));
                player.setBats(record.get("bats"));
                player.setNumberOfthrows(record.get("throws"));
                player.setDebut(parseDateOrNull(record.get("debut")));
                player.setFinalGame(parseDateOrNull(record.get("finalGame")));
                player.setRetroID(record.get("retroID"));
                player.setBbrefID(record.get("bbrefID"));
                players.add(player);
            }
        }
        playersRepository.saveAll(players);
    }
    
}
