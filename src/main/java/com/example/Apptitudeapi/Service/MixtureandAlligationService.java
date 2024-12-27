package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.MixtureandAlligationRepository;
import com.example.Apptitudeapi.model.MixtureandAlligation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MixtureandAlligationService {

    private final MixtureandAlligationRepository mixtureandAlligationRepository;

    @Autowired
    public MixtureandAlligationService(MixtureandAlligationRepository mixtureandAlligationRepository) {
        this.mixtureandAlligationRepository = mixtureandAlligationRepository;
    }

    // Fetch all MixtureandAlligation records
    public List<MixtureandAlligation> getAllMixtureandAlligations() {
        return mixtureandAlligationRepository.findAll();
    }

    // Fetch a random MixtureandAlligation record
    public MixtureandAlligation getRandomMixtureandAlligation() {
        List<MixtureandAlligation> allMixtureandAlligations = mixtureandAlligationRepository.findAll();
        if (allMixtureandAlligations.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(allMixtureandAlligations.size());
        return allMixtureandAlligations.get(randomIndex);
    }

    // Fetch n random MixtureandAlligation records
    public List<MixtureandAlligation> getRandomNumbers(int n) {
        List<MixtureandAlligation> allMixtureandAlligations = mixtureandAlligationRepository.findAll();
        List<MixtureandAlligation> questions = new ArrayList<>();

        // Ensure we do not exceed the list size
        if (n > allMixtureandAlligations.size()) {
            n = allMixtureandAlligations.size();  // Limit to the available records
        }

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(allMixtureandAlligations.size());  // Corrected random index range
            questions.add(allMixtureandAlligations.get(randomNumber));
        }
        return questions;
    }
}

