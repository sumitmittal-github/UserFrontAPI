package com.sumit.api.controller;

import com.sumit.api.entity.InputParams;
import com.sumit.api.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/add")
    public String add(@ModelAttribute InputParams inputParams){
        System.out.println("Entry CalculatorController.add with inputParams :"+inputParams);
        return calculatorService.add(inputParams);
    }

    @PostMapping("/addAll")
    public String addAll(@RequestBody List<Long> allInputParams){
        System.out.println("Entry CalculatorController.addAll with inputParams :"+allInputParams);
        return calculatorService.addAll(allInputParams);
    }
}