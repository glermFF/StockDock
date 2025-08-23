package ufop.edu.web.stockdock.Investments.dtos.Assets;

import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;

public record CreateAssetDTO(String name, AssetEnumType type, Integer quantity, Double purchasedPrice) {}