package com.example.guessinggame.business;

import com.example.guessinggame.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GameService {

    // This Class should update new random number every new session
    // Should also check if player is inside the database;
    @Autowired
    PersonRepository personRepository;
    Person playerPerson;
    Random random = new Random();

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void add(String name) {
        List<Person> personList = personRepository.findByName(name);
        if (personList.size() == 0) {
            Person person = personRepository.save(new Person(name));
            playerPerson = person;
        }
        else {
            playerPerson= personList.get(0);
        }
    }
    public String guessHighOrLow(int guees){

        if (guees>secret){
            return "To Big Number";
        }
        else if (guees<secret){
            return "To Low Number";
        }
        return "The Right Number";
    }

    private int secret;

    public GameService() {
        init();
    }

    private void init() {
        secret = random.nextInt(1, 100);
    }


}
