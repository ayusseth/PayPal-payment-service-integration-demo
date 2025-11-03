package com.ayush.demo_paypal.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HttpServiceEngine {
    private final RestClient restClient;

    String client_secret="ARiJ_svAuZoRiSUVLJkrMHz8Ex6f75xc_nR3t4we89xo4sgny6sj3KAi56Yj5S-uhXyJP67Y0mbBBJSr";
    String client_ID="EI_m1u0XkQMvt3s_7UAsIXkvGMjQ3INooaUCg8l9WSyx-ANn_8r6CcaHrYdV5sUf8HJATTAiBi6ccEN1";
    String getAuthUrl="https://api-m.sandbox.paypal.com/v1/oauth2/token";
    public String makeRequest() {
        log.info("Making HTTP request");
        // Simulate HTTP request logic here
        return "response";
    }
}
