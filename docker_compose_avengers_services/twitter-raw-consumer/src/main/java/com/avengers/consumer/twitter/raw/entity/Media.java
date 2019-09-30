package com.avengers.consumer.twitter.raw.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Media implements Serializable {
    private String display_url;
    private String expanded_url;
    private BigInteger id;
    private String id_str;
    private List<Integer> indices;
    private String media_url;
    private String media_url_https;
}
