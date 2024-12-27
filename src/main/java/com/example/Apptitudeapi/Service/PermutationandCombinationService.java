package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.PermutationandCombinationRepository;
import com.example.Apptitudeapi.model.PermutationandCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service // Annotate this class to mark it as a Spring service
public class PermutationandCombinationService {

    private final PermutationandCombinationRepository permutationandCombinationRepository;

    @Autowired
    public PermutationandCombinationService(PermutationandCombinationRepository permutationandCombinationRepository) {
        this.permutationandCombinationRepository = permutationandCombinationRepository;
    }

    public List<PermutationandCombination> getAllPermutationandCombinations() {
        // Fetch all PermutationandCombination objects
        return permutationandCombinationRepository.findAll();
    }

    public PermutationandCombination getRandomPermutationandCombination() {
        // Fetch all PermutationandCombination objects
        List<PermutationandCombination> allItems = permutationandCombinationRepository.findAll();
        if (allItems.isEmpty()) {
            return null; // Handle case where no documents exist
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allItems.size()); // Generate a random index
        return allItems.get(randomIndex);
    }

    public List<PermutationandCombination> getRandomPermutationandCombinations(int n) {
        List<PermutationandCombination> allItems = permutationandCombinationRepository.findAll();
        if (allItems.isEmpty()) {
            return new ArrayList<>(); // Return an empty list if no documents exist
        }

        List<PermutationandCombination> randomItems = new ArrayList<>();
        Random random = new Random();

        // Generate `n` random PermutationandCombination objects
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allItems.size()); // Ensure valid random index
            randomItems.add(allItems.get(randomIndex));
        }
        return randomItems;
    }
}


