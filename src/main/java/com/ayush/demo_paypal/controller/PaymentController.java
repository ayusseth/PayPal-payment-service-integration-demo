package com.ayush.demo_paypal.controller;

import com.ayush.demo_paypal.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController
{
    private final PaymentServiceImpl paymentServiceImpl;

    @PostMapping
    public String createOrder()
    {
        log.info("Creating Order");
        return paymentServiceImpl.createOrder();

    }
}
