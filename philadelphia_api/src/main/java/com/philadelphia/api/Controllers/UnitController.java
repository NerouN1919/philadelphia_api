package com.philadelphia.api.Controllers;

import com.philadelphia.api.DTO.AddUnitDTO;
import com.philadelphia.api.DTO.GetUnitDTO;
import com.philadelphia.api.Database.Units;
import com.philadelphia.api.Services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/units")
public class UnitController {
    @Autowired
    private UnitService unitService;
    @PostMapping
    public void addUnit(@RequestBody AddUnitDTO addUnitDTO){
        unitService.addUnit(addUnitDTO);
    }
    @GetMapping
    public List<GetUnitDTO> getAllUnits(){
        return unitService.getAllUnits();
    }
    @GetMapping("/{number}")
    public GetUnitDTO getUnitByNumber(@PathVariable("number") Long number){
        return unitService.getUnitByNumber(number);
    }
}
