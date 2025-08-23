package ufop.edu.web.stockdock.Investments.dtos.Assets;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAssetPriceDTO {
    
    private UUID id;

    private Double priceModel;
    private Double newPrice;

    private LocalDateTime updatedAt;
}
