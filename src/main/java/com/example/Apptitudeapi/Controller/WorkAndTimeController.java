package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.WorkAndTimeService;
import com.example.Apptitudeapi.model.WorkAndTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkAndTimeController {
    private final WorkAndTimeService workAndTimeService;

    public WorkAndTimeController(WorkAndTimeService workAndTimeService) {
        this.workAndTimeService = workAndTimeService;
    }

    @GetMapping("/workandtimes")
    public List<WorkAndTime> getAllWorkAndTime() {
        return workAndTimeService.getAllWorkAndTime();
    }

    @GetMapping("/workandtime")
    public WorkAndTime getRandomWorkAndTime() {
        return workAndTimeService.getRandomWorkAndTime();
    }


    @GetMapping("/workandtimes/{number}")
    public List<WorkAndTime> getNumberOfWorkAndTime(@PathVariable int number) {
        return workAndTimeService.getRandomWorkAndTimeNumbers(number);
    }
}



