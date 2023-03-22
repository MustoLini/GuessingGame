package com.example.guessinggame.business;

public class PersonDTO implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        PersonDTO personDTO=(PersonDTO) o;
        return Double.compare(this.averageResult, personDTO.averageResult);
    }
}
