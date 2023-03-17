package com.example.guessinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    // Need to have Post mapping here
    @Autowired
    GameService gameService;
    // Need to have Get mapping here also that will get

}
