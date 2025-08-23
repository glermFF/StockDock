package ufop.edu.web.stockdock.Investments.dtos.Assets;

import java.time.LocalDateTime;
import java.util.UUID;

import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;

public record SimpleAssetDTO(UUID id, String name, AssetEnumType type, Integer quantity, Double purchasedPrice, LocalDateTime purchasedAt) {}