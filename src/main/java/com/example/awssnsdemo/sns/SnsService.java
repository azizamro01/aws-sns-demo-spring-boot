package com.example.awssnsdemo.sns;

import com.example.awssnsdemo.message.MessageRequest;
import com.example.awssnsdemo.message.MessageResponse;

public interface SnsService {

    MessageResponse sendMessage(final MessageRequest message);
}
