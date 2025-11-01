package com.ayush.demo_paypal.service;

import com.ayush.demo_paypal.http.HttpServiceEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenService
{
    private final HttpServiceEngine httpServiceEngine;
    private static String accessToken;
    public String getToken()
    {
        log.info("Getting Token");
        if(accessToken != null)
        {
            log.info("Returning cached access token");
            return accessToken;
        }
        log.info("No cached token found, making HTTP request to get new token");
        String httpRequest= httpServiceEngine.makeRequest();
        log.info("Received HTTP response: {}", httpRequest);
        return httpRequest;
    }
}
