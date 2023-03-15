package com.example.guessinggame;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
   // Find By name Add att later Point
    List<Person> findByName(String name);
}
