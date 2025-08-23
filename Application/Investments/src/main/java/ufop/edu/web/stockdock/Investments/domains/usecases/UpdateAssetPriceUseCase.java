package ufop.edu.web.stockdock.Investments.domains.usecases;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateAssetPriceUseCase {
    
    private UUID assetIdModel;
    private UUID assetIdPassed;
    
    private Double assetPriceModel;
    private Double newAssetPrice;

    public void validate(){
        validateAssetId();
        validateAssetPrice();
    }

    public void validateAssetId(){
        if(!assetIdModel.equals(assetIdPassed)){
            throw new RuntimeException("No Asset found");
        }
    }

    public void validateAssetPrice(){
        if(assetPriceModel.equals(newAssetPrice)){
            throw new RuntimeException("Price already set");
        }
    }
}
