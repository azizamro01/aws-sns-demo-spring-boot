package com.example.awssnsdemo;

public interface SnsService {

    MessageResponse sendMessage(final MessageRequest message);
}
