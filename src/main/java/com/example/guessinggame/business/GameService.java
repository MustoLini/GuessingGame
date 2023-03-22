package com.example.guessinggame.business;

import com.example.guessinggame.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    Result result;
    private int secret;

    public GameService() {
    }

    public List<PersonDTO> getResult() {
        return personRepository
                .findAll()
                .stream()
                .map(person -> new PersonDTO(
                        person.getName(),
                        person
                                .getResults()
                                .stream()
                                .map(Result::getResult)
                                .reduce(0, Integer::sum) * 1.0 / person.getResults().size()))
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person add(String name) {
        Optional<Person> personOptional = personRepository.findByName(name);
        if (personOptional.isEmpty()) {
            playerPerson = personRepository.save(new Person(name));
        } else {
            playerPerson = personOptional.get();
        }
        secret = random.nextInt(1, 100);
        result = new Result();
        return playerPerson;
    }

    public String guessHighOrLow(int guees) {

        if (guees > secret) {
            System.out.println(result.getAndIncrement() + "Number of guess");
            return "This number: " + guees + " To Big Number";
        } else if (guees < secret) {
            System.out.println(result.getAndIncrement() + "Number of guess");
            return "This number: " + guees + " To Low Number";
        }
        System.out.println(result.getAndIncrement() + "Number of guess");
        playerPerson.addResult(result);
        personRepository.save(playerPerson);
        return "This number: " + guees + " The Right Number";
    }


}
