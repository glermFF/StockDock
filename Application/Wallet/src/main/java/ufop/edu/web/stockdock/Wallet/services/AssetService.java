package ufop.edu.web.stockdock.Wallet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Wallet.converter.AssetConverter;
import ufop.edu.web.stockdock.Wallet.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Wallet.model.AssetModel;
import ufop.edu.web.stockdock.Wallet.repo.IAssetRepository;

@Service
@AllArgsConstructor
public class AssetService {
    
    private final IAssetRepository assetRepository;

    public List<SimpleAssetDTO> getAllAssets(){

        List<AssetModel> assetModel = assetRepository.findAll();

        return assetModel.stream().map(AssetConverter::toAssetDTO).toList();
    }
}