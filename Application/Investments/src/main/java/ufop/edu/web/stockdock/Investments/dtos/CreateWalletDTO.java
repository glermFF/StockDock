package ufop.edu.web.stockdock.Investments.dtos;

import ufop.edu.web.stockdock.Investments.enums.WalletEnumType;

public record CreateWalletDTO(String walletName, WalletEnumType type) {}