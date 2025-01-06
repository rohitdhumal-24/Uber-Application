package com.rohit.project.uber.uberApp.services.Impl;

import com.rohit.project.uber.uberApp.entities.Payment;
import com.rohit.project.uber.uberApp.entities.Ride;
import com.rohit.project.uber.uberApp.entities.enums.PaymentStatus;
import com.rohit.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.rohit.project.uber.uberApp.repositories.PaymentRepository;
import com.rohit.project.uber.uberApp.services.PaymentService;
import com.rohit.project.uber.uberApp.strategies.PaymentStrategyManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentStrategyManager paymentStrategyManager;

    public void processPayment(Ride ride){
        Payment payment = paymentRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not fond for the Ride : "+ride.getId()));
        paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);
    }

    public Payment createNewPayment(Ride ride){
    Payment payment = Payment.builder()
            .ride(ride)
            .paymentMethod(ride.getPaymentMethod())
            .amount(ride.getFare())
            .paymentStatus(PaymentStatus.PENDING)
            .build();
    return paymentRepository.save(payment);
    }

    @Override
    public void updatePaymentStatus(Payment payment, PaymentStatus status) {
        payment.setPaymentStatus(status);
        paymentRepository.save(payment);

    }

}
