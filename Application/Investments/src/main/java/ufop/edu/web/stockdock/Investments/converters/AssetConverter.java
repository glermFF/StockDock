package ufop.edu.web.stockdock.Investments.converters;

import java.util.UUID;

import ufop.edu.web.stockdock.Investments.domains.AssetDomain;
import ufop.edu.web.stockdock.Investments.dtos.Assets.CreateAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.UpdateAssetPriceDTO;
import ufop.edu.web.stockdock.Investments.models.AssetModel;
import ufop.edu.web.stockdock.Investments.models.WalletModel;

public class AssetConverter {
    
    public static SimpleAssetDTO toAssetDTO(AssetModel assetModel){
        UUID walletId = assetModel.getWallet() != null ? assetModel.getWallet().getId() : null;
        return new SimpleAssetDTO(assetModel.getId(), assetModel.getName(), assetModel.getType(), walletId, assetModel.getQuantity(), assetModel.getPurchasedPrice(), assetModel.getPurchasedAt());
    }

    public static AssetModel toAssetModel(AssetDomain assetDomain){
        return AssetModel.builder().id(assetDomain.getId()).name(assetDomain.getName()).quantity(assetDomain.getQuantity()).type(assetDomain.getType()).wallet(WalletModel.builder().id(assetDomain.getWallet()).build()).purchasedPrice(assetDomain.getPurchasedPrice()).build();
    }

    public static AssetModel toAssetModel(SimpleAssetDTO simpleAssetDTO) {
        return AssetModel.builder().id(simpleAssetDTO.id()).name(simpleAssetDTO.name()).type(simpleAssetDTO.type()).wallet(WalletModel.builder().id(simpleAssetDTO.wallet()).build()).quantity(simpleAssetDTO.quantity()).purchasedPrice(simpleAssetDTO.purchasedPrice()).purchasedAt(simpleAssetDTO.purchasedAt()).build();
    }

    public static AssetDomain toAssetDoamDomain(CreateAssetDTO createAssetDTO){
        return AssetDomain.builder().name(createAssetDTO.name()).quantity(createAssetDTO.quantity()).purchasedPrice(createAssetDTO.purchasedPrice()).type(createAssetDTO.type()).wallet(createAssetDTO.wallet()).build();
    }

    public static AssetDomain toAssetDomain(UpdateAssetPriceDTO updateAssetPriceDTO){
        return AssetDomain.builder().id(updateAssetPriceDTO.getId()).purchasedPrice(updateAssetPriceDTO.getPriceModel()).build();
    }
}