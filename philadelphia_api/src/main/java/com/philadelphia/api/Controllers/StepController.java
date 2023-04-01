package com.philadelphia.api.Controllers;

import com.philadelphia.api.DTO.AddStepDTO;
import com.philadelphia.api.Services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/steps")
public class StepController {
    @Autowired
    private StepService stepService;
    @PostMapping
    public void addStep(@RequestBody AddStepDTO addStepDTO){
        stepService.addStep(addStepDTO);
    }
    @GetMapping("/{number}")
    public Object getStepByNumber(@PathVariable("number") Long number){
        return stepService.getStepByNumber(number);
    }
}
