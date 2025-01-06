package com.rohit.project.uber.uberApp.dto;

import lombok.Data;

import java.util.List;
@Data
public class WalletDto {

    private Long id;

    private UserDto user;

    private Double balance;    // wallet contain some balance it is.

    private List<WalletTransactionDto> transaction;
}
