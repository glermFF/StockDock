package ufop.edu.web.stockdock.Investments.dtos;

import java.util.List;
import java.util.UUID;

import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.enums.WalletEnumType;

public record SimpleWalletDTO(UUID id, String walletName, WalletEnumType type, List<SimpleAssetDTO> asset) {}