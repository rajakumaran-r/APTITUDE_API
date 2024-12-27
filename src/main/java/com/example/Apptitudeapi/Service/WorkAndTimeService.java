package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.WorkAndTimeRepository;
import com.example.Apptitudeapi.model.WorkAndTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WorkAndTimeService {
    private final WorkAndTimeRepository workAndTimeRepository;

    @Autowired
    public WorkAndTimeService(WorkAndTimeRepository workAndTimeRepository) {
        this.workAndTimeRepository = workAndTimeRepository;
    }

    public List<WorkAndTime> getAllWorkAndTime() {
        return workAndTimeRepository.findAll();
    }

    public WorkAndTime getRandomWorkAndTime() {
        List<WorkAndTime> allWorkAndTime = workAndTimeRepository.findAll(); // Fetch all documents
        if (allWorkAndTime.isEmpty()) {
            return null; // Handle case where no documents exist
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allWorkAndTime.size()); // Generate a random index
        return allWorkAndTime.get(randomIndex);
    }

    public List<WorkAndTime> getRandomWorkAndTimeNumbers(@RequestParam int n) {
        List<WorkAndTime> allWorkAndTime = workAndTimeRepository.findAll();
        List<WorkAndTime> questions = new ArrayList<>();

        // Generate n random numbers
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(allWorkAndTime.size()); // Random number between 0 and allWorkAndTime.size()
            questions.add(allWorkAndTime.get(randomNumber));
        }
        return questions;
    }
}
