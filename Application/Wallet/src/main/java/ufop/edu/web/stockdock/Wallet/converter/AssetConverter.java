package ufop.edu.web.stockdock.Wallet.converter;

import ufop.edu.web.stockdock.Wallet.domain.AssetDomain;
import ufop.edu.web.stockdock.Wallet.dtos.SimpleAssetDTO;
import ufop.edu.web.stockdock.Wallet.model.AssetModel;

public class AssetConverter {
    
    public static SimpleAssetDTO toAssetDTO(AssetModel assetModel){
        return new SimpleAssetDTO(assetModel.getId(), assetModel.getName(), assetModel.getType(), assetModel.getCurrentPrice());
    }

    public static AssetModel toAssetModel(AssetDomain assetDomain){
        return AssetModel.builder().id(assetDomain.getId()).name(assetDomain.getName()).type(assetDomain.getType()).currentPrice(assetDomain.getCurrentPrice()).build();
    }

    // requisition methods
}
