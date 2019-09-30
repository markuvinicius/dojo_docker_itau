package com.avengers.consumer.twitter.raw.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class UserMention implements Serializable {
    private BigInteger id;
    private String id_str;
    private List<Integer> indices;
    private String name;
    private String screen_name;
}
