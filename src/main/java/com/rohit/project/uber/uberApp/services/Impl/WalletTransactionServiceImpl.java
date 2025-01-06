package com.rohit.project.uber.uberApp.services.Impl;

import com.rohit.project.uber.uberApp.dto.WalletTransactionDto;
import com.rohit.project.uber.uberApp.entities.WalletTransaction;
import com.rohit.project.uber.uberApp.repositories.WalletTransactionRepository;
import com.rohit.project.uber.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
        // To convert the Dto to entity
    }
}