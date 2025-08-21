package ufop.edu.web.stockdock.Wallet.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufop.edu.web.stockdock.Wallet.enums.AssetEnumType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetDomain {
    private UUID id;

    private String name;

    private AssetEnumType type;

    private Double currentPrice;

    private LocalDateTime purchasedAt;
}
