package com.avengers.consumer.twitter.raw.listener;

import com.amazonaws.services.comprehend.model.Entity;
import com.amazonaws.services.comprehend.model.KeyPhrase;
import com.amazonaws.services.comprehend.model.SentimentScore;
import com.avengers.consumer.twitter.raw.Application;
import com.avengers.consumer.twitter.raw.entity.Tweet;
import com.avengers.consumer.twitter.raw.service.AwsComprehendService;
import com.avengers.consumer.twitter.raw.service.TweetMongoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TwitterRawMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(TwitterRawMessageListener.class);

    private AwsComprehendService service;
    private TweetMongoServiceImpl serviceTweet;

    @Autowired
    public TwitterRawMessageListener(AwsComprehendService service,
                                     TweetMongoServiceImpl serviceTweet){
        this.service = service;
        this.serviceTweet = serviceTweet;
    }

    @RabbitListener(queues = Application.QUEUE_SPECIFIC_NAME)
    public void receiveTweet(Tweet tweet){
        SentimentScore sentimentScore =  this.service.detectSentiment( tweet.getTexto() );
        List<Entity> entities = this.service.detectEntities(tweet.getTexto());
        List<KeyPhrase> keyPhrases = this.service.detectKeyPhrasesRequest(tweet.getTexto());


        tweet.setSentiment(sentimentScore);
        this.serviceTweet.save(tweet);

        logger.info("Sentimento: " + sentimentScore.toString());
    }

}
