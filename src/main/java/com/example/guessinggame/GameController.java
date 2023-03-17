package com.example.guessinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    // Need to have Post mapping here
    @Autowired
    GameService gameService;
    // Need to have Get mapping here also that will get

    @PostMapping("/login")
    public String login(@RequestParam("name") String name , Model model){
        // Login in method;
        return "gissapage";
    }
}
