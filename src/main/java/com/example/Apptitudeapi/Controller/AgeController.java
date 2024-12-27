package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.AgeService;
import com.example.Apptitudeapi.model.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AgeController {
    private final AgeService ageService;

    @Autowired
    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }
    @GetMapping("/ages")
    public List<Age> getAllAges() {
        return ageService.getAllAges();
    }
    @GetMapping("/age")
    public Age getRandomAge() {
        return ageService.getRandomAge();
    }
    @GetMapping("/ages/{number}")
    public List<Age> getNumberOfAges(@PathVariable int number) {
        return ageService.getRandomNumbers(number);
    }

}
