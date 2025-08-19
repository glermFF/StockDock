package ufop.edu.web.stockdock.Wallet.dtos;

import java.util.UUID;

public record SimpleWalletDTO(UUID id, String walletName, String type) {}