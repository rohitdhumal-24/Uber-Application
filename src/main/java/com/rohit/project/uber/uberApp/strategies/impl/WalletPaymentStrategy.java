package com.rohit.project.uber.uberApp.strategies.impl;

import com.rohit.project.uber.uberApp.entities.Driver;
import com.rohit.project.uber.uberApp.entities.Payment;
import com.rohit.project.uber.uberApp.entities.Rider;
import com.rohit.project.uber.uberApp.entities.enums.PaymentStatus;
import com.rohit.project.uber.uberApp.entities.enums.TransactionMethod;
import com.rohit.project.uber.uberApp.repositories.PaymentRepository;
import com.rohit.project.uber.uberApp.services.PaymentService;
import com.rohit.project.uber.uberApp.services.WalletService;
import com.rohit.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Rider had -> 230 And Driver had -->500
//Ride cost is 100rs also 30% commission i.e 30rs
//Rider -> 230 - 100 = 130,
//Driver -> 500 + (100 - 30 = 70) = 570.

@Service
@AllArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Transactional
    @Override
    public void processPayment(Payment payment) {
    // lets get the Driver and Rider
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

    // Get the wallet of both, hence call walletService
        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(),
                null,payment.getRide(), TransactionMethod.RIDE);

    // Cutting the commission from the transaction of the Ride
        // (PLATFORM_COMMISSION = 0.3,Hence 1 - 0.3 = 0.7 amount added driver wallet)
        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

         walletService.addMoneyToWallet(driver.getUser(),driversCut,
            null,payment.getRide(),TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);


    }
}
