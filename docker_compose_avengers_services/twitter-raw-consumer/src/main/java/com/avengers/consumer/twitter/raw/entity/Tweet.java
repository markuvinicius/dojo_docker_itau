package com.avengers.consumer.twitter.raw.entity;

import com.amazonaws.services.comprehend.model.Entity;
import com.amazonaws.services.comprehend.model.KeyPhrase;
import com.amazonaws.services.comprehend.model.SentimentScore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@ToString
@Document(collection="tweets")
public class Tweet implements Serializable {
    @Id
    @JsonProperty("id")
    private String id;
    public String getId(){ return this.getId(); }

    @JsonProperty("data")
    private String data;

    @JsonProperty("texto")
    private String texto;

    public String getTexto(){ return this.texto; }

    @JsonProperty("user")
    private User user;

    @JsonProperty("retweeted")
    private boolean retweeted;

    @JsonProperty("quoted")
    private boolean quoted;

    @JsonProperty("quote_count")
    private Integer quote_count;

    @JsonProperty("reply_count")
    private Integer reply_count;

    @JsonProperty("retweet_count")
    private Integer retweet_count;

    @JsonProperty("favorite_count")
    private Integer favorite_count;

    @JsonProperty("location")
    private String location;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("geo")
    private String geo;

    @JsonProperty("coordinates")
    private String coordinates;

    @JsonProperty("place")
    private String place;

    private SentimentScore sentiment;

    public String getData() {
        return data;
    }

    public User getUser() {
        return user;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public boolean isQuoted() {
        return quoted;
    }

    public Integer getQuote_count() {
        return quote_count;
    }

    public Integer getReply_count() {
        return reply_count;
    }

    public Integer getRetweet_count() {
        return retweet_count;
    }

    public Integer getFavorite_count() {
        return favorite_count;
    }

    public String getLocation() {
        return location;
    }

    public String getLang() {
        return lang;
    }

    public String getGeo() {
        return geo;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getPlace() {
        return place;
    }

    public SentimentScore getSentiment() {
        return sentiment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public void setQuoted(boolean quoted) {
        this.quoted = quoted;
    }

    public void setQuote_count(Integer quote_count) {
        this.quote_count = quote_count;
    }

    public void setReply_count(Integer reply_count) {
        this.reply_count = reply_count;
    }

    public void setRetweet_count(Integer retweet_count) {
        this.retweet_count = retweet_count;
    }

    public void setFavorite_count(Integer favorite_count) {
        this.favorite_count = favorite_count;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSentiment(SentimentScore sentiment) {
        this.sentiment = sentiment;
    }
}
