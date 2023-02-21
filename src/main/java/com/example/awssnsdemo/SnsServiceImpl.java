package com.example.awssnsdemo;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SnsServiceImpl implements SnsService {

    private final AmazonSNSClient amazonSNSClient;

    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest) {
        try {
            return MessageResponse.success(amazonSNSClient.publish(toAwsPublishRequest(messageRequest)).getMessageId());
        } catch (RuntimeException ex) {
            return MessageResponse.failure();
        }
    }

    private PublishRequest toAwsPublishRequest(MessageRequest request) {
        Map<String, MessageAttributeValue> attributes = new HashMap<>();
        attributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                .withStringValue("AzizAmro")
                .withDataType("String"));
        return new PublishRequest()
                .withMessage(request.getBody())
                .withPhoneNumber(request.getPhoneNumber())
                .withMessageAttributes(attributes);
    }
}
