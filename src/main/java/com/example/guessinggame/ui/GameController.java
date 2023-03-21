package com.example.guessinggame.ui;

import com.example.guessinggame.business.GameService;
import com.example.guessinggame.business.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GameController {
    // Need to have Post mapping here
    @Autowired
    GameService gameService;
    // Need to have Get mapping here also that will get

    @PostMapping("/login")
    public String login(@RequestParam String name, Model model) {
        // Login in method;
        model.addAttribute("person", gameService.add(name));
        return "redirect:/guess";
    }
    @GetMapping("/guess")
    public String guessView(Model model){
        return "guessWebsite";
    }
    @PostMapping("/guess")
    public String guessLowOrHigh(@RequestParam int guess, Model model){
        String guessText = gameService.guessHighOrLow(guess);
        model.addAttribute("guess", guessText);
        return "guessWebsite";
    }


    @GetMapping("/login")
    public String addLogin(Model model){
        model.addAttribute("person", new Person());
        return "guessWebsite";
    }
    @GetMapping("/result")
    String getResult(Model model){
        model.addAttribute("results", gameService.getResult());
        return "showAverageAndTries";
    }

    @PostMapping ("/all")
    String getAll(Model model){
        model.addAttribute("gueesList", gameService.getAll());
        return "showAverageAndTries";
    }
}
