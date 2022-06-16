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
    public String add(@RequestBody List<Long> inputs){
        System.out.println("Entry CalculatorController.add() ...");
        System.out.println("inputs :"+inputs);
        String response = calculatorService.add(inputs);
        System.out.println("response : "+response);
        System.out.println("Exit CalculatorController.add() !!!");
        return response;
    }
}