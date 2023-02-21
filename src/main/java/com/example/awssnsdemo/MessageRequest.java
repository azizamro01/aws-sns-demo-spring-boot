package com.example.awssnsdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {
    private String phoneNumber;
    private String body;
}
