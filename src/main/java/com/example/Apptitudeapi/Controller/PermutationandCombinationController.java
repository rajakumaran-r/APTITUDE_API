package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.PermutationandCombinationService;
import com.example.Apptitudeapi.model.PermutationandCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Mark this class as a REST controller
public class PermutationandCombinationController {

    private final PermutationandCombinationService permutationandCombinationService;

    @Autowired
    public PermutationandCombinationController(PermutationandCombinationService permutationandCombinationService) {
        this.permutationandCombinationService = permutationandCombinationService;
    }

    // Endpoint to fetch all Permutation and Combination objects
    @GetMapping("/permutationandcombinations")
    public List<PermutationandCombination> getAllPermutationAndCombinations() {
        return permutationandCombinationService.getAllPermutationandCombinations();
    }

    // Endpoint to fetch a single random Permutation and Combination object
    @GetMapping("/permutationandcombination")
    public PermutationandCombination getRandomPermutationAndCombination() {
        return permutationandCombinationService.getRandomPermutationandCombination();
    }

    // Endpoint to fetch a specified number of random Permutation and Combination objects
    @GetMapping("/permutationandcombination/{number}")
    public List<PermutationandCombination> getRandomPermutationAndCombinations(@PathVariable int number) {
        return permutationandCombinationService.getRandomPermutationandCombinations(number);
    }
}


