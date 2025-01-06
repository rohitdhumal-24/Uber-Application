package com.rohit.project.uber.uberApp.dto;

import com.rohit.project.uber.uberApp.entities.enums.TransactionMethod;
import com.rohit.project.uber.uberApp.entities.enums.TransactionType;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDto {

    private Long Id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne()
    private RideDto ride;

    private String transactionId;

    private WalletDto wallet;

    private LocalDateTime timeStamp;
}
