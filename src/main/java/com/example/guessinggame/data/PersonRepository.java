package com.example.guessinggame.data;

import com.example.guessinggame.business.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
   // Find By name Add att later Point

}
