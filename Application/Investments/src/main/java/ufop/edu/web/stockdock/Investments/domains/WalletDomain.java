package ufop.edu.web.stockdock.Investments.domains;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufop.edu.web.stockdock.Investments.enums.WalletEnumType;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletDomain {
    private UUID id;

    private String walletName;

    private WalletEnumType type;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
