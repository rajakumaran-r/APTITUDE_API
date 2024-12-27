package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.RandomQuestionsService;
import com.example.Apptitudeapi.model.RandomQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RandomQuestionsController {

    public final RandomQuestionsService randomQuestionsService;

    @Autowired
    public RandomQuestionsController(RandomQuestionsService randomQuestionsService) {
        this.randomQuestionsService = randomQuestionsService;
    }

    @GetMapping("/randoms")
    public List<RandomQuestions> getAllRandomQuestions() {
        return randomQuestionsService.getAllRandomQuestions();
    }

    @GetMapping("/random")
    public RandomQuestions getRandomQuestion() {
        return randomQuestionsService.getRandomQuestion();
    }

    @GetMapping("/randoms/{number}")
    public List<RandomQuestions> getRandomQuestionsByNumber(@PathVariable int number) {
        return randomQuestionsService.getRandomQuestions(number);
    }

    @GetMapping("/random-questions")
    public List<RandomQuestions> getRandomQuestionsByParam(@RequestParam int n) {
        return randomQuestionsService.getRandomQuestions(n);
    }
}
