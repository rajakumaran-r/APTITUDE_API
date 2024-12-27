package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.RandomQuestionsRepository;
import com.example.Apptitudeapi.model.RandomQuestions; // Assuming your model class is RandomQuestions
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomQuestionsService {

    // Inject the RandomQuestionsRepository dependency
    public final RandomQuestionsRepository randomQuestionsRepository;

    @Autowired
    public RandomQuestionsService(RandomQuestionsRepository randomQuestionsRepository) {
        this.randomQuestionsRepository = randomQuestionsRepository;
    }

    // Method to get all random questions
    public List<RandomQuestions> getAllRandomQuestions() {
        return randomQuestionsRepository.findAll(); // Fetch all random questions from the database
    }

    // Method to get a single random question
    public RandomQuestions getRandomQuestion() {
        List<RandomQuestions> allQuestions = randomQuestionsRepository.findAll(); // Fetch all questions
        if (allQuestions.isEmpty()) {
            return null; // Handle the case where no questions exist
        }

        // Generate a random index and return the question at that index
        Random random = new Random();
        int randomIndex = random.nextInt(allQuestions.size()); // Random index generation
        return allQuestions.get(randomIndex); // Return the random question
    }

    // Method to get multiple random questions (n random questions)
    public List<RandomQuestions> getRandomQuestions(@RequestParam int n) {
        List<RandomQuestions> allQuestions = randomQuestionsRepository.findAll();
        List<RandomQuestions> randomQuestionsList = new ArrayList<>();

        // Generate n random questions
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allQuestions.size()); // Random index generation
            randomQuestionsList.add(allQuestions.get(randomIndex)); // Add the random question to the list
        }

        return randomQuestionsList; // Return the list of random questions
    }
}
