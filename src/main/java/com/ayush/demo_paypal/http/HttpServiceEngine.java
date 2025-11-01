package com.ayush.demo_paypal.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HttpServiceEngine {
    public String makeRequest() {
        log.info("Making HTTP request");
        // Simulate HTTP request logic here
        return "response";
    }
}
