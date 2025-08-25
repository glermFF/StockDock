package ufop.edu.web.stockdock.Investments.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.enums.WalletEnumType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWalletDTO {
    private UUID id;

    private String walletName;

    List<SimpleAssetDTO> assets;

    private WalletEnumType type;

    private LocalDateTime updatedAt;
}
