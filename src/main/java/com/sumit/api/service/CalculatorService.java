package com.sumit.api.service;

import com.sumit.api.entity.InputParams;
import com.sumit.api.utils.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private InputValidator inputValidator;

    public String add(InputParams inputParams) {
        System.out.println("CalculatorService.add with inputParams :"+inputParams);
        return inputParams.toString();
    }

    public String addAll(List<Long> inputs) {
        System.out.println("CalculatorService.add with inputParams :"+inputs);

        // validate input params, if valid then proceed further, else send error response to caller
        String validationMsg = inputValidator.validateAddAllInput(inputs);
        if(validationMsg != null)
            return  validationMsg;

        // send message to Amazon SQS
        Long sum = inputs.stream().reduce(0L, Long::sum);
        System.out.println("SUM = " + sum);
        return "Results sent for processing";
    }



}