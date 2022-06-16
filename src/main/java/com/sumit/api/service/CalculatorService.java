package com.sumit.api.service;

import com.sumit.api.entity.InputParams;
import com.sumit.api.entity.OperationType;
import com.sumit.api.entity.SQSMessage;
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

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String sqsQueueEndPoint;

    public String add(List<Long> inputs) {
        System.out.println("Entry CalculatorService.add() ...");
        System.out.println("inputs :"+inputs);
        System.out.println("sqsQueueEndPoint :"+sqsQueueEndPoint);

        // validate input params, if valid then proceed further, else send error response to caller
        String validationMsg = inputValidator.validateAddAllInput(inputs);
        System.out.println("validationMsg :"+validationMsg);
        if(validationMsg != null)
            return  validationMsg;

        // send message to Amazon SQS
        SQSMessage sqsMessage = new SQSMessage(inputs, OperationType.ADD);
        System.out.println("Sending message to SQS, sqsMessage : "+sqsMessage);
        queueMessagingTemplate.send(sqsQueueEndPoint, MessageBuilder.withPayload(sqsMessage).build());
        System.out.println("Message Sent to SQS!!");
        System.out.println("Exit CalculatorService.add() !!!");
        return "Results sent for processing";
    }



}