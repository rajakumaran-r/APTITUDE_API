package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.SpeedTimeDistanceService;
import com.example.Apptitudeapi.model.SpeedTimeDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpeedTimeDistanceController {

    private final SpeedTimeDistanceService speedTimeDistanceService;

    // Constructor injection for SpeedTimeDistanceService
    @Autowired
    public SpeedTimeDistanceController(SpeedTimeDistanceService speedTimeDistanceService) {
        this.speedTimeDistanceService = speedTimeDistanceService;
    }

    // Fetch all SpeedTimeDistance records
    @GetMapping("/speedTimeDistances")
    public List<SpeedTimeDistance> getAllSpeedTimeDistances() {
        return speedTimeDistanceService.getAllSpeedTimeDistances();
    }

    // Fetch a random SpeedTimeDistance record
    @GetMapping("/speedTimeDistance")
    public SpeedTimeDistance getRandomSpeedTimeDistance() {
        return speedTimeDistanceService.getRandomSpeedTimeDistance();
    }

    // Fetch a specific number of SpeedTimeDistance records
    @GetMapping("/speedTimeDistances/{number}")
    public List<SpeedTimeDistance> getNumberOfSpeedTimeDistances(@PathVariable int number) {
        return speedTimeDistanceService.getRandomSpeedTimeDistances(number);
    }
}


