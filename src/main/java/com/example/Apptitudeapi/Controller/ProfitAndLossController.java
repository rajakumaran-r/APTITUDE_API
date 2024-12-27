package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.ProfitAndLossService;
import com.example.Apptitudeapi.model.ProfitAndLoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfitAndLossController {

    private final ProfitAndLossService profitAndLossService;

    @Autowired
    public ProfitAndLossController(ProfitAndLossService profitAndLossService) {
        this.profitAndLossService = profitAndLossService;
    }

    // Endpoint to fetch all ProfitAndLoss records
    @GetMapping("/profitAndLosses")
    public List<ProfitAndLoss> getAllProfitAndLosses() {
        return profitAndLossService.getAllProfitAndLosses();
    }

    // Endpoint to fetch a specific number of random ProfitAndLoss records
    @GetMapping("/profitAndLosses/{number}")
    public List<ProfitAndLoss> getNumberOfProfitAndLosses(@PathVariable int number) {
        return profitAndLossService.getRandomNumbers(number);
    }

    // Endpoint to fetch a single random ProfitAndLoss record
    @GetMapping("/profitAndLoss")
    public ProfitAndLoss getRandomProfitAndLoss() {
        return profitAndLossService.getRandomProfitAndLoss();
    }
}
