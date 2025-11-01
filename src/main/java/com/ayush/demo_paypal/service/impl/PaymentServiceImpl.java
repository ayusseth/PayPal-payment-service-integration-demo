package com.ayush.demo_paypal.service.impl;

import com.ayush.demo_paypal.service.TokenService;
import com.ayush.demo_paypal.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TokenService tokenService;

    @Override
    public String createOrder() {
        log.info("Creating service order");
        String response= tokenService.getToken();
        log.info("Received token: {}", response);
        return response;
    }
}
