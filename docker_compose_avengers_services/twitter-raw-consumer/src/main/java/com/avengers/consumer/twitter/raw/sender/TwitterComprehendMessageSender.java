package com.avengers.consumer.twitter.raw.sender;

import com.amazonaws.services.comprehend.model.SentimentScore;
import com.avengers.consumer.twitter.raw.entity.Tweet;
import com.avengers.consumer.twitter.raw.listener.TwitterRawMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterComprehendMessageSender {
    private static final Logger logger = LoggerFactory.getLogger(TwitterRawMessageListener.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public TwitterComprehendMessageSender(final RabbitTemplate template){
        this.rabbitTemplate = template;
    }

    public void sendMessage(Tweet tweet, SentimentScore sentimentScore){
        //TODO
    }

}
