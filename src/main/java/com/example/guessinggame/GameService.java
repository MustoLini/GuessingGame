package com.example.guessinggame;

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

    // Should person be here?
    private Person person;
    private int secret;

    public GameService() {
        init();
    }

    private void init() {
        secret = random.nextInt(1, 100);
        person = new Person();
    }


}
