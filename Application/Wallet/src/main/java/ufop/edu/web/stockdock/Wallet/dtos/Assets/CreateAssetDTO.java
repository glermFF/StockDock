package ufop.edu.web.stockdock.Wallet.dtos.Assets;

import ufop.edu.web.stockdock.Wallet.enums.AssetEnumType;

public record CreateAssetDTO(String name, AssetEnumType type, Double currentPrice) {}