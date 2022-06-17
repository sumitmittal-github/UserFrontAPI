package com.sumit.api.utils;

import com.sumit.api.error.InvalidInputException;
import com.sumit.api.entity.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InputValidator {

    /*
    Addition and Multiplication can have more than 2 argument
    Subtraction and Division should have only 2 arguments
    In Division, 2nd number can not be 0
     */
    public String validateInputs(OperationType operationType, List<Double> inputs) throws InvalidInputException {
        if(inputs == null || inputs.size()<2)
            throw new InvalidInputException("Please provide at least 2 numbers !!");
        else if((OperationType.SUBTRACT == operationType || OperationType.DIVIDE == operationType) && inputs.size()>2)
            throw new InvalidInputException("Input numbers can not be more than 2 !!");
        else if(OperationType.DIVIDE == operationType && inputs.get(1)==0.0)
            throw new InvalidInputException("In division 2nd number can not be 0 !!");
        else
            return null;
    }
}