package com.exam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWS_S3_Config {

    @Value("${aws.region}")
    private String region;
    @Value("${aws.s3.credentials.access-key}")
    private String accessKey;
    @Value("${aws.s3.credentials.secret-key}")
    private String secretKey;
    
    @Bean
    public AmazonS3 awsS3Client() {

    	BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
    	
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();
    }
}
