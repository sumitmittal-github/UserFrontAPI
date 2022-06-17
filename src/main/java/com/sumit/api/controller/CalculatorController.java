package com.sumit.api.controller;

import com.sumit.api.entity.OperationType;
import com.sumit.api.error.InvalidInputException;
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
    public String add(@RequestBody List<Double> inputs) throws InvalidInputException {
        System.out.println("Entry CalculatorController.add() ...");
        System.out.println("inputs :"+inputs);
        String response = calculatorService.validateAndSendSQSMessage(inputs, OperationType.ADD);
        System.out.println("response : "+response);
        System.out.println("Exit CalculatorController.add() !!!");
        return response;
    }

    @PostMapping("/subtract")
    public String subtract(@RequestBody List<Double> inputs) throws InvalidInputException {
        System.out.println("Entry CalculatorController.subtract() ...");
        System.out.println("inputs :"+inputs);
        String response = calculatorService.validateAndSendSQSMessage(inputs, OperationType.SUBTRACT);
        System.out.println("response : "+response);
        System.out.println("Exit CalculatorController.subtract() !!!");
        return response;
    }

    @PostMapping("/multiply")
    public String multiply(@RequestBody List<Double> inputs) throws InvalidInputException {
        System.out.println("Entry CalculatorController.multiply() ...");
        System.out.println("inputs :"+inputs);
        String response = calculatorService.validateAndSendSQSMessage(inputs, OperationType.MULTIPLY);
        System.out.println("response : "+response);
        System.out.println("Exit CalculatorController.multiply() !!!");
        return response;
    }

    @PostMapping("/divide")
    public String divide(@RequestBody List<Double> inputs) throws InvalidInputException {
        System.out.println("Entry CalculatorController.divide() ...");
        System.out.println("inputs :"+inputs);
        String response = calculatorService.validateAndSendSQSMessage(inputs, OperationType.DIVIDE);
        System.out.println("response : "+response);
        System.out.println("Exit CalculatorController.divide() !!!");
        return response;
    }

}