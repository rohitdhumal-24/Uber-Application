package com.rohit.project.uber.uberApp.strategies;

import com.rohit.project.uber.uberApp.entities.Payment;

public interface PaymentStrategy {

    void processPayment(Payment payment);

    Double PLATFORM_COMMISSION = 0.3;

}
