package com.example.guessinggame.business;

public class PersonDTO {
    private String name;
    private Double averageResult;

    public PersonDTO(String name, Double averageResult) {
        this.name = name;
        this.averageResult = averageResult;
    }

    public String getName() {
        return name;
    }

    public Double getAverageResult() {
        return averageResult;
    }
}
