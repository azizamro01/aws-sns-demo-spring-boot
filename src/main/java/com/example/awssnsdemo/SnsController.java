package com.example.awssnsdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class SnsController {
    private final SnsService service;

    @GetMapping("/send")
    public MessageResponse sendMessage(@RequestBody MessageRequest request) {
        return service.sendMessage(request);
    }
}
