package com.sumit.api.SQS;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 Configuration class to get an object of the Queue Messaging template
 By using this template we can communicate with our Amazon SQS queue.
 */
@Configuration
public class AmazonSQSConfiguration {

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(buildAmazonSQSAsync());
    }

    public AmazonSQSAsync buildAmazonSQSAsync() {
        System.out.println("Entry AwsSQSConfig ...");
        System.out.println("region = "+region);
        System.out.println("awsAccessKey = "+awsAccessKey);
        System.out.println("awsSecretKey = "+awsSecretKey);
        AmazonSQSAsync amazonSQSAsync = AmazonSQSAsyncClientBuilder
                                        .standard()
                                        .withRegion(region)
                                        .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                                        .build();
        System.out.println("amazonSQSAsync = "+amazonSQSAsync);
        System.out.println("Exit AwsSQSConfig !!!");
        return amazonSQSAsync;
    }



}