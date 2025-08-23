package ufop.edu.web.stockdock.Investments.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWalletName {
    
    private UUID id;

    // private String userId;

    private String walletNameModel;
    private String newWalletName;

    private LocalDateTime updatedAt;
}
