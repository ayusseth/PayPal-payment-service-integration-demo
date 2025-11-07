package com.ayush.demo_paypal.http;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Data
public class HttpRequest {
    private String url;
    private HttpMethod method;
    private Object body;
    private HttpHeaders headers;
}
