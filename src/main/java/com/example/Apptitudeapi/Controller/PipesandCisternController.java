package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.PipesandCisternService;
import com.example.Apptitudeapi.model.PipesandCistern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PipesandCisternController {

    private final PipesandCisternService pipesandCisternService;

    @Autowired
    public PipesandCisternController(PipesandCisternService pipesandCisternService) {
        this.pipesandCisternService = pipesandCisternService;
    }

    // Get all Pipes and Cistern records
    @GetMapping("/pipesandcisterns")
    public List<PipesandCistern> getAllPipesandCisterns() {
        return pipesandCisternService.getAllPipesandCisterns();
    }

    // Get a random Pipes and Cistern record
    @GetMapping("/pipesandcistern")
    public PipesandCistern getRandomPipesandCistern() {
        return pipesandCisternService.getRandomPipesandCistern();
    }

    // Get n random Pipes and Cistern records
    @GetMapping("/pipesandcisterns/{number}")
    public List<PipesandCistern> getNumberOfPipesandCisterns(@PathVariable int number) {
        return pipesandCisternService.getRandomPipesandCisterns(number);
    }
}
