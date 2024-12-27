package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.SimpleInterestService;
import com.example.Apptitudeapi.model.SimpleInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleInterestController {
    private final SimpleInterestService simpleInterestService;

    @Autowired
    public SimpleInterestController(SimpleInterestService simpleInterestService) {
        this.simpleInterestService = simpleInterestService;
    }

    // Fetch all SimpleInterest records
    @GetMapping("/simpleInterests")
    public List<SimpleInterest> getAllSimpleInterests() {
        return simpleInterestService.getAllSimpleInterests();
    }

    // Fetch a random SimpleInterest question
    @GetMapping("/simpleInterest")
    public String getRandomSimpleInterestQuestion() {
        return simpleInterestService.getRandomSimpleInterestQuestion(); // Correct method name
    }

    // Fetch 'n' random SimpleInterest questions
    @GetMapping("/simpleInterests/{number}")
    public List<String> getNumberOfSimpleInterestQuestions(@PathVariable int number) {
        return simpleInterestService.getRandomSimpleInterestQuestions(number);
    }
}

