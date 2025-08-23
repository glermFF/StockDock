package ufop.edu.web.stockdock.Investments.converters;

import ufop.edu.web.stockdock.Investments.domains.AssetDomain;
import ufop.edu.web.stockdock.Investments.dtos.Assets.CreateAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.UpdateAssetPriceDTO;
import ufop.edu.web.stockdock.Investments.models.AssetModel;

public class AssetConverter {
    
    public static SimpleAssetDTO toAssetDTO(AssetModel assetModel){
        return new SimpleAssetDTO(assetModel.getId(), assetModel.getName(), assetModel.getType(), assetModel.getCurrentPrice());
    }

    public static AssetModel toAssetModel(AssetDomain assetDomain){
        return AssetModel.builder().id(assetDomain.getId()).name(assetDomain.getName()).type(assetDomain.getType()).currentPrice(assetDomain.getCurrentPrice()).build();
    }

    public static AssetDomain toAssetDoamDomain(CreateAssetDTO createAssetDTO){
        return AssetDomain.builder().name(createAssetDTO.name()).currentPrice(createAssetDTO.currentPrice()).type(createAssetDTO.type()).build();
    }

    public static AssetDomain toAssetDomain(UpdateAssetPriceDTO updateAssetPriceDTO){
        return AssetDomain.builder().id(updateAssetPriceDTO.getId()).currentPrice(updateAssetPriceDTO.getPriceModel()).build();
    }
}