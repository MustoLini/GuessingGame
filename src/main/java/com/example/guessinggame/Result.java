package com.example.guessinggame;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue
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

    public Result(Long id, int result) {
        this.id = id;
        this.result = result;
    }
}
