package com.philadelphia.api.Controllers;

import com.philadelphia.api.DTO.AddStepDTO;
import com.philadelphia.api.Services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/steps")
public class StepController {
    @Autowired
    private StepService stepService;
    @PostMapping
    public void addStep(@RequestBody AddStepDTO addStepDTO){
        stepService.addStep(addStepDTO);
    }

}
