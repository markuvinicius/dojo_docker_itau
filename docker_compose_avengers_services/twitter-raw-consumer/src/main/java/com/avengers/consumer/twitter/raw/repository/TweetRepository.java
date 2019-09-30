package com.avengers.consumer.twitter.raw.repository;

import com.avengers.consumer.twitter.raw.entity.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TweetRepository extends MongoRepository<Tweet, String> {
}
