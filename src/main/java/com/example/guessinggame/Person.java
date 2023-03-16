package com.example.guessinggame;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Result> result;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
