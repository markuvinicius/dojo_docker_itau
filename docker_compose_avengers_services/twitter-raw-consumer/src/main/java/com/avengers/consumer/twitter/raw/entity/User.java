package com.avengers.consumer.twitter.raw.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @NonNull
    private String id;
    private String name;
    private String screen_name;
    private String location;
    private int followers_count;
    private int friends_count;
}
