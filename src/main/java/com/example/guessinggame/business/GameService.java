package com.example.guessinggame.business;

import com.example.guessinggame.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Random;

@Service
@SessionScope
public class GameService {

    // This Class should update new random number every new session
    // Should also check if player is inside the database;
    @Autowired
    PersonRepository personRepository;
    Random random = new Random();

    public void add(Person person){
        personRepository.save(person);
    }
    private int secret;

    public GameService() {
        init();
    }

    private void init() {
        secret = random.nextInt(1, 100);
    }


}
