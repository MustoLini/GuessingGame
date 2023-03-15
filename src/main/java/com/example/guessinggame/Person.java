package com.example.guessinggame;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private double guesses;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setGuesses(double guesses) {
        this.guesses = guesses;
    }

    public double getGuesses() {
        return guesses;
    }
}
