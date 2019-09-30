package com.avengers.consumer.twitter.raw.service;

import java.util.List;
import com.amazonaws.services.comprehend.model.*;
import org.springframework.stereotype.Service;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;


@Service
public class AwsComprehendService {

    private AmazonComprehend comprehendClient;

    public AwsComprehendService() {
        AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

        comprehendClient = AmazonComprehendClientBuilder.standard()
                .withCredentials(awsCreds)
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    public void detectEntitiesRequest(String text) {
        DetectEntitiesRequest detectEntitiesRequest = new DetectEntitiesRequest().withText(text)
                .withLanguageCode("pt");
        DetectEntitiesResult detectEntitiesResult  = comprehendClient.detectEntities(detectEntitiesRequest);
        detectEntitiesResult.getEntities().forEach(System.out::println);
    }

    public List<KeyPhrase> detectKeyPhrasesRequest(String text) {
        DetectKeyPhrasesRequest detectKeyPhrasesRequest = new DetectKeyPhrasesRequest().withText(text)
                .withLanguageCode("pt");
        DetectKeyPhrasesResult detectKeyPhrasesResult = comprehendClient.detectKeyPhrases(detectKeyPhrasesRequest);
        return detectKeyPhrasesResult.getKeyPhrases();
    }

    public SentimentScore detectSentiment(String text) {
        DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
                .withLanguageCode("pt");
        DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
        return detectSentimentResult.getSentimentScore();
    }

    public List<Entity> detectEntities(String text) {
        DetectEntitiesRequest detectEntitiesRequest = new DetectEntitiesRequest().withText(text)
                .withLanguageCode("pt");
        DetectEntitiesResult detectEntitiesResult  = comprehendClient.detectEntities(detectEntitiesRequest);
        return detectEntitiesResult.getEntities();
    }

}