package com.example.guessinggame.business;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personner")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany
    private List<Result> result;
    public void addResult(int numberOfGuess){
        result.add(new Result(numberOfGuess));
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Long id, String name, List<Result> result) {
        this.id = id;
        this.name = name;
        this.result = result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }
}
