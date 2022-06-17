package com.sumit.api.service;

import com.sumit.api.entity.OperationType;
import com.sumit.api.SQS.AmazonSQSMessage;
import com.sumit.api.error.InvalidInputException;
import com.sumit.api.utils.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private InputValidator inputValidator;

    @Value("${cloud.aws.end-point.uri}")
    private String sqsQueueEndPoint;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public String validateAndSendSQSMessage(List<Double> inputs, OperationType operationType) throws InvalidInputException {
        System.out.println("Entry CalculatorService.validateAndSendSQSMessage() ...");
        System.out.println("inputs :"+inputs);
        System.out.println("operationType :"+operationType);
        System.out.println("sqsQueueEndPoint :"+sqsQueueEndPoint);

        // validate input params, if valid then proceed further, else send error response to caller
        String validationMsg = inputValidator.validateInputs(operationType, inputs);
        System.out.println("validationMsg :"+validationMsg);
        if(validationMsg != null)
            return validationMsg;

        // send message to Amazon SQS
        AmazonSQSMessage amazonSQSMessage = new AmazonSQSMessage(operationType, inputs);
        System.out.println("Sending message to SQS, sqsMessage : "+amazonSQSMessage);
        queueMessagingTemplate.send(sqsQueueEndPoint, MessageBuilder.withPayload(amazonSQSMessage).build());
        System.out.println("Message Sent to SQS!!");
        System.out.println("Exit CalculatorService.validateAndSendSQSMessage() !!!");
        return "Results sent for processing";
    }

}