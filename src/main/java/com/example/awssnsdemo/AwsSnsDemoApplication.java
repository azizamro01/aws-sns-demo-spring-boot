package com.example.awssnsdemo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSAsyncClient;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwsSnsDemoApplication {
    private final String accessKey = "";
    private final String secretKey = "";

    public static void main(String[] args) {
        SpringApplication.run(AwsSnsDemoApplication.class, args);
    }

    @Bean
    public AmazonSNSAsyncClient amazonSNSAsyncClient() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return (AmazonSNSAsyncClient) AmazonSNSAsyncClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();

    }

}
