package com.sumit.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumit.api.SQS.AmazonSQSMessage;
import com.sumit.api.error.InvalidInputException;
import com.sumit.api.entity.OperationType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculatorUtils {

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

    public String parseAmazonSQSMessageObjectToJSON(AmazonSQSMessage amazonSQSMessage) throws InvalidInputException {
        System.out.println("Entry CalculatorUtils.parseAmazonSQSMessageObjectToJSON() ...");
        String amazonSQSMessageJson = null;
        try{
            System.out.println("amazonSQSMessage object:"+amazonSQSMessage);
            ObjectMapper objectMapper = new ObjectMapper();
            amazonSQSMessageJson = objectMapper.writeValueAsString(amazonSQSMessage);
            System.out.println("amazonSQSMessage JSON:"+amazonSQSMessageJson);
        } catch(Exception e){
            throw new InvalidInputException("Exception occurred while parsing SQS Object to JSON");
        }
        System.out.println("Exit CalculatorUtils.parseAmazonSQSMessageObjectToJSON() !!!");
        return amazonSQSMessageJson;
    }
}