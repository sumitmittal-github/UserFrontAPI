package com.sumit.api.utils;

import com.sumit.api.entity.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InputValidator {

    public String validateInputs(OperationType operationType, List<Double> inputs){
        if(inputs == null || inputs.size()<2)
            return "please provide at least 2 numbers";
        else if(OperationType.DIVIDE == operationType && inputs.contains(0.0D))
            return "0 is not allowed in division";
        else
            return null;
    }
}