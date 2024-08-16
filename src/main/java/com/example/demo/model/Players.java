package com.example.demo.model;

import java.time.LocalDate;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Players")
public class Players {

    @Id
    private String playerID;
    
    @Nullable
    private Integer birthYear;
    @Nullable
    private Integer birthMonth;
    @Nullable
    private Integer birthDay;
    @Nullable
    private String birthCountry;
    @Nullable
    private String birthState;
    @Nullable
    private String birthCity;
    @Nullable
    private Integer deathYear;
    @Nullable
    private Integer deathMonth;
    @Nullable
    private Integer deathDay;
    @Nullable
    private String deathCountry;
    @Nullable
    private String deathState;
    @Nullable
    private String deathCity;
    @Nullable
    private String nameFirst;
    @Nullable
    private String nameLast;
    @Nullable
    private String nameGiven;
    @Nullable
    private Integer weight;
    @Nullable
    private Integer height;
    @Nullable
    private String bats;
    @Nullable
    private String numberOfthrows;
    @Nullable
    private LocalDate debut;
    @Nullable
    private LocalDate finalGame;
    @Nullable
    private String retroID;
    @Nullable
    private String bbrefID;

    public String getPlayerID() {
        return playerID;
    }
    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }
    public Integer getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(Integer i) {
        this.birthYear = i;
    }
    public Integer getBirthMonth() {
        return birthMonth;
    }
    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }
    public Integer getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }
    public String getBirthCountry() {
        return birthCountry;
    }
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }
    public String getBirthState() {
        return birthState;
    }
    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }
    public String getBirthCity() {
        return birthCity;
    }
    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }
    public Integer getDeathYear() {
        return deathYear;
    }
    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }
    public Integer getDeathMonth() {
        return deathMonth;
    }
    public void setDeathMonth(Integer deathMonth) {
        this.deathMonth = deathMonth;
    }
    public Integer getDeathDay() {
        return deathDay;
    }
    public void setDeathDay(Integer deathDay) {
        this.deathDay = deathDay;
    }
    public String getDeathCountry() {
        return deathCountry;
    }
    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }
    public String getDeathState() {
        return deathState;
    }
    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }
    public String getDeathCity() {
        return deathCity;
    }
    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }
    public String getNameFirst() {
        return nameFirst;
    }
    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }
    public String getNameLast() {
        return nameLast;
    }
    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }
    public String getNameGiven() {
        return nameGiven;
    }
    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public String getBats() {
        return bats;
    }
    public void setBats(String bats) {
        this.bats = bats;
    }
    public String getNumberOfthrows() {
        return numberOfthrows;
    }
    public void setNumberOfthrows(String numberOfthrows) {
        this.numberOfthrows = numberOfthrows;
    }
    public LocalDate getDebut() {
        return debut;
    }
    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }
    public LocalDate getFinalGame() {
        return finalGame;
    }
    public void setFinalGame(LocalDate finalGame) {
        this.finalGame = finalGame;
    }
    public String getRetroID() {
        return retroID;
    }
    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }
    public String getBbrefID() {
        return bbrefID;
    }
    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }
}


