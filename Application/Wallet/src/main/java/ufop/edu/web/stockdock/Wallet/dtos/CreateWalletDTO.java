package ufop.edu.web.stockdock.Wallet.dtos;

import ufop.edu.web.stockdock.Wallet.enums.WalletEnumType;

public record CreateWalletDTO(String walletName, WalletEnumType type) {}