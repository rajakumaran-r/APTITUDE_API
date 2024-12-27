package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.SpeedTimeDistanceRepository;
import com.example.Apptitudeapi.model.SpeedTimeDistance;
import org.springframework.stereotype.Service; // Import and add @Service annotation
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service // This annotation is crucial!
public class SpeedTimeDistanceService {

    private final SpeedTimeDistanceRepository speedTimeDistanceRepository;

    public SpeedTimeDistanceService(SpeedTimeDistanceRepository speedTimeDistanceRepository) {
        this.speedTimeDistanceRepository = speedTimeDistanceRepository;
    }

    public List<SpeedTimeDistance> getAllSpeedTimeDistances() {
        return speedTimeDistanceRepository.findAll();
    }

    public SpeedTimeDistance getRandomSpeedTimeDistance() {
        List<SpeedTimeDistance> allSpeedTimeDistances = speedTimeDistanceRepository.findAll();
        if (allSpeedTimeDistances.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allSpeedTimeDistances.size());
        return allSpeedTimeDistances.get(randomIndex);
    }

    public List<SpeedTimeDistance> getRandomSpeedTimeDistances(@RequestParam int n) {
        if (n <= 0) {
            return new ArrayList<>(); // Return empty list for invalid input
        }

        List<SpeedTimeDistance> allSpeedTimeDistances = speedTimeDistanceRepository.findAll();
        if (allSpeedTimeDistances.isEmpty()) {
            return new ArrayList<>(); // Return empty list if no questions available
        }

        List<SpeedTimeDistance> questions = new ArrayList<>();
        Random random = new Random();

        // Ensure we don't try to get more questions than available
        int numQuestionsToGenerate = Math.min(n, allSpeedTimeDistances.size());

        for (int i = 0; i < numQuestionsToGenerate; i++) {
            int randomIndex = random.nextInt(allSpeedTimeDistances.size());
            questions.add(allSpeedTimeDistances.get(randomIndex));
            allSpeedTimeDistances.remove(randomIndex); //prevent duplicates
        }
        return questions;
    }
}
