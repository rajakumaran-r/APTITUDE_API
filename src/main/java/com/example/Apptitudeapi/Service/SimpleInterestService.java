package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.SimpleInterestRepository;
import com.example.Apptitudeapi.model.SimpleInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SimpleInterestService {
    public final SimpleInterestRepository simpleInterestRepository;

    @Autowired
    public SimpleInterestService(SimpleInterestRepository simpleInterestRepository) {
        this.simpleInterestRepository = simpleInterestRepository;
    }

    // Fetch all SimpleInterest records
    public List<SimpleInterest> getAllSimpleInterests() {
        return simpleInterestRepository.findAll();
    }

    // Fetch a random SimpleInterest record's question
    public String getRandomSimpleInterestQuestion() {
        List<SimpleInterest> allSimpleInterests = simpleInterestRepository.findAll(); // Fetch all records
        if (allSimpleInterests.isEmpty()) {
            return null; // Handle case where no records exist
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allSimpleInterests.size()); // Generate a random index
        return allSimpleInterests.get(randomIndex).getQuestion(); // Return the randomly selected question
    }

    // Fetch 'n' random SimpleInterest questions
    public List<String> getRandomSimpleInterestQuestions(@RequestParam int n) {
        List<SimpleInterest> allSimpleInterests = simpleInterestRepository.findAll(); // Fetch all records
        List<String> questions = new ArrayList<>();

        // Generate n random questions
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allSimpleInterests.size()); // Generate a random index
            questions.add(allSimpleInterests.get(randomIndex).getQuestion()); // Add the randomly selected question to the list
        }

        return questions; // Return the list of random questions
    }
}
