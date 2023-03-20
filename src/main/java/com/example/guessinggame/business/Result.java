package com.example.guessinggame.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int result;
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Result() {
    }

    public Result(int result) {
        this.result = result;
    }

    public Result(Long id, int result) {
        this.id = id;
        this.result = result;
    }
}
