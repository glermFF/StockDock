package ufop.edu.web.stockdock.Wallet.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletDomain {
    private UUID id;

    private String walletName;

    private String type;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
