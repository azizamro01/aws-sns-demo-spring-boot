package com.example.awssnsdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {
    private String sequenceNumber;
    private MessageStatus status;

    public static MessageResponse success(String sequenceNumber) {
        return new MessageResponse(sequenceNumber, MessageStatus.DELIVERED);
    }

    public static MessageResponse failure() {
        return new MessageResponse(null, MessageStatus.FAILED);
    }
}
