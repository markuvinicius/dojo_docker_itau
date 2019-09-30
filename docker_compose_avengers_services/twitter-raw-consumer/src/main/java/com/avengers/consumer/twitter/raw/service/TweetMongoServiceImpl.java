package com.avengers.consumer.twitter.raw.service;

import com.avengers.consumer.twitter.raw.entity.Tweet;
import com.avengers.consumer.twitter.raw.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetMongoServiceImpl {

    private TweetRepository repository;

    @Autowired
    public TweetMongoServiceImpl(TweetRepository repo){
        this.repository = repo;
    }

    public Tweet save(Tweet tweet){
        return this.repository.save(tweet);
    }
}
