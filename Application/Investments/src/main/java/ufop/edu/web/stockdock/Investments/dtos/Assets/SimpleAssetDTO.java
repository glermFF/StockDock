package ufop.edu.web.stockdock.Investments.dtos.Assets;

import java.util.UUID;

import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;

public record SimpleAssetDTO(UUID id, String name, AssetEnumType type, Double currentPrice) {}