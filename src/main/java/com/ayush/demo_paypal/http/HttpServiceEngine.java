package com.ayush.demo_paypal.http;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
@RequiredArgsConstructor
public class HttpServiceEngine {
    private final RestClient restClient;


    public ResponseEntity<String> makeRequest(HttpRequest httpRequest) {
        log.info("Making HTTP request");

        ResponseEntity<String> response = restClient.method(HttpMethod.POST)
                .uri(httpRequest.getUrl())
                .headers(headers -> headers
                        .addAll(httpRequest.getHeaders()))
                .body(httpRequest.getBody())
                .retrieve()
                .toEntity(String.class);
        log.info("HTTp request made to PayPal API for token");
        return response;
    }
}
