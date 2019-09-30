package com.avengers.consumer.twitter.raw.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Url implements Serializable {
    private String display_url;
    private String expanded_url;
    private List<Integer> indices;
    private String url;
}