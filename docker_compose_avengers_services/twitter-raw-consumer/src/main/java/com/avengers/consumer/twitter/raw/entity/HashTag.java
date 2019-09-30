package com.avengers.consumer.twitter.raw.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HashTag implements Serializable {
    private List<Integer> indices;
    private String text;
}
