package com.rohit.project.uber.uberApp.strategies.impl;

import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.Payment;
import com.rohit.project.uber.uberApp.entities.enums.PaymentStatus;
import com.rohit.project.uber.uberApp.entities.enums.TransactionMethod;
import com.rohit.project.uber.uberApp.repositories.PaymentRepository;
import com.rohit.project.uber.uberApp.services.PaymentService;
import com.rohit.project.uber.uberApp.services.WalletService;
import com.rohit.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Online payment -->100 (70rs charges + 30rs Commission of Application)
//COD --> Rider Give 100 hence 30rs Deducted from the Driver Wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();


        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(),platformCommission,
                null,payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
        ;
    }
}
