package ufop.edu.web.stockdock.Wallet.dtos.Assets;

import java.util.UUID;

import ufop.edu.web.stockdock.Wallet.enums.AssetEnumType;

public record SimpleAssetDTO(UUID id, String name, AssetEnumType type, Double currentPrice) {}