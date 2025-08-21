package ufop.edu.web.stockdock.Wallet.dtos;

import java.util.UUID;

import ufop.edu.web.stockdock.Wallet.enums.WalletEnumType;

public record SimpleWalletDTO(UUID id, String walletName, WalletEnumType type) {}