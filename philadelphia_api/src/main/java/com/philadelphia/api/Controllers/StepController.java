package com.philadelphia.api.Controllers;

import com.philadelphia.api.DTO.AddStepDTO;
import com.philadelphia.api.Services.StepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/steps")
@Tag(name = "Controller for steps in units")
public class StepController {
    @Autowired
    private StepService stepService;
    @PostMapping
    @Operation(summary = "Add step to unit")
    public void addStep(@RequestBody AddStepDTO addStepDTO){
        stepService.addStep(addStepDTO);
    }
    @GetMapping("/{number}/{numberUnit}")
    @Operation(summary = "Get step by number")
    public Object getStepByNumber(@PathVariable("number") Long number, @PathVariable("numberUnit") Long numberUnit){
        return stepService.getStepByNumber(number, numberUnit);
    }
}
