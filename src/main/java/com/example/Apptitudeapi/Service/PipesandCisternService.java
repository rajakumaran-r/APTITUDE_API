package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.PipesandCisternRepository;
import com.example.Apptitudeapi.model.PipesandCistern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service  // Add this annotation to make the class a Spring-managed service
public class PipesandCisternService {
    private final PipesandCisternRepository pipesandCisternRepository;

    public PipesandCisternService(PipesandCisternRepository pipesandCisternsRepository) {
        this.pipesandCisternRepository = pipesandCisternsRepository;
    }

    public List<PipesandCistern> getAllPipesandCisterns() {
        return pipesandCisternRepository.findAll();
    }

    public PipesandCistern getRandomPipesandCistern() {
        List<PipesandCistern> allPipesandCisterns = pipesandCisternRepository.findAll();
        if (allPipesandCisterns.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allPipesandCisterns.size());
        return allPipesandCisterns.get(randomIndex);
    }

    public List<PipesandCistern> getRandomPipesandCisterns(int n) {
        List<PipesandCistern> allPipesandCisterns = pipesandCisternRepository.findAll();
        List<PipesandCistern> randomPipesandCisterns = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allPipesandCisterns.size());
            randomPipesandCisterns.add(allPipesandCisterns.get(randomIndex));
        }

        return randomPipesandCisterns;
    }
}


