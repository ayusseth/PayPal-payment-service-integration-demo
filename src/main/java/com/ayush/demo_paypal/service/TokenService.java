package com.ayush.demo_paypal.service;

import com.ayush.demo_paypal.constant.Constant;
import com.ayush.demo_paypal.http.HttpRequest;
import com.ayush.demo_paypal.http.HttpServiceEngine;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenService
{
    private final HttpServiceEngine httpServiceEngine;
    private static String accessToken;

    @Value("${paypal.client.id}")
    private  String clientID;
    @Value("${paypal.client.secret}")
    private  String clientSecret;
    @Value("${paypal.oauth.url}")
    private  String oauthUrl;

    public String getToken()
    {
        log.info("Getting Token");
        if(accessToken != null)
        {
            log.info("Returning cached access token");
            return accessToken;
        }
        log.info("No cached token found, making HTTP request to get new token");

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(clientID, clientSecret);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add(Constant.GRANT_TYPE, Constant.CLIENT_CREDENTIALS);

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setMethod(HttpMethod.POST);
        httpRequest.setUrl(oauthUrl);
        httpRequest.setHeaders(headers);
        httpRequest.setBody(formData);

        log.info("Making HTTP request to PayPal OAuth URL: {}", oauthUrl);

        ResponseEntity<String> response= httpServiceEngine.makeRequest(httpRequest);
        log.info("Received HTTP response: {}", response);
        String tokenBody= response.getBody();
        log.info("Token Body: {}", tokenBody);
        return tokenBody;
    }
}
