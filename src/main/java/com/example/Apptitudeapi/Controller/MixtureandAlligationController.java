package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.MixtureandAlligationService;
import com.example.Apptitudeapi.model.MixtureandAlligation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MixtureandAlligationController {

    private final MixtureandAlligationService mixtureandAlligationService;

    @Autowired
    public MixtureandAlligationController(MixtureandAlligationService mixtureandAlligationService) {
        this.mixtureandAlligationService = mixtureandAlligationService;
    }

    // Fetch all MixtureandAlligation records
    @GetMapping("/mixtureandAlligations")
    public List<MixtureandAlligation> getAllMixtureandAlligations() {
        return mixtureandAlligationService.getAllMixtureandAlligations();  // Fixed method call
    }

    // Fetch a random MixtureandAlligation record
    @GetMapping("/mixtureandAlligation")
    public MixtureandAlligation getRandomMixtureandAlligation() {
        return mixtureandAlligationService.getRandomMixtureandAlligation();  // Fixed method call
    }

    // Fetch n random MixtureandAlligation records using a path variable
    @GetMapping("/mixtureandAlligations/{number}")
    public List<MixtureandAlligation> getNumberOfMixtureandAlligations(@PathVariable int number) {
        return mixtureandAlligationService.getRandomNumbers(number);  // Correct service method call
    }
}

