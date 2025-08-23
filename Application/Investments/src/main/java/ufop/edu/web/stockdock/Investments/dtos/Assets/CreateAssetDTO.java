package ufop.edu.web.stockdock.Investments.dtos.Assets;

import java.util.UUID;

import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;

public record CreateAssetDTO(String name, AssetEnumType type, UUID wallet, Integer quantity, Double purchasedPrice) {}