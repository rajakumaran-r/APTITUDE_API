package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.ProfitAndLossRepository;
import com.example.Apptitudeapi.model.ProfitAndLoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProfitAndLossService {

    private final ProfitAndLossRepository profitAndLossRepository;

    @Autowired
    public ProfitAndLossService(ProfitAndLossRepository profitAndLossRepository) {
        this.profitAndLossRepository = profitAndLossRepository;
    }

    // Fetch all ProfitAndLoss records
    public List<ProfitAndLoss> getAllProfitAndLosses() {
        return profitAndLossRepository.findAll();
    }

    // Fetch a single random ProfitAndLoss record
    public ProfitAndLoss getRandomProfitAndLoss() {
        List<ProfitAndLoss> allProfitAndLosses = profitAndLossRepository.findAll();

        if (allProfitAndLosses.isEmpty()) {
            return null; // Return null if no records are found
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allProfitAndLosses.size());
        return allProfitAndLosses.get(randomIndex);
    }

    // Fetch a specific number of random ProfitAndLoss records
    public List<ProfitAndLoss> getRandomNumbers(int n) {
        List<ProfitAndLoss> allProfitAndLosses = profitAndLossRepository.findAll();

        if (allProfitAndLosses.isEmpty()) {
            return new ArrayList<>(); // Return an empty list if no records are found
        }

        List<ProfitAndLoss> randomQuestions = new ArrayList<>();
        Random random = new Random();

        // Ensure `n` does not exceed the total number of records
        n = Math.min(n, allProfitAndLosses.size());

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allProfitAndLosses.size());
            randomQuestions.add(allProfitAndLosses.get(randomIndex));
        }

        return randomQuestions;
    }
}
