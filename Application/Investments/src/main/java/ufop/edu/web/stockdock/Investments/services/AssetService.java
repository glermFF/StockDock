package ufop.edu.web.stockdock.Investments.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Investments.converters.AssetConverter;
import ufop.edu.web.stockdock.Investments.domains.AssetDomain;
import ufop.edu.web.stockdock.Investments.domains.usecases.UpdateAssetPriceUseCase;
import ufop.edu.web.stockdock.Investments.dtos.Assets.CreateAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.RemoveAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.UpdateAssetPriceDTO;
import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;
import ufop.edu.web.stockdock.Investments.models.AssetModel;
import ufop.edu.web.stockdock.Investments.repositories.IAssetRepository;

@Service
@AllArgsConstructor
public class AssetService {
    
    private final IAssetRepository assetRepository;

    public List<SimpleAssetDTO> getAllAssets(){

        List<AssetModel> assetModel = assetRepository.findAll();

        return assetModel.stream().map(AssetConverter::toAssetDTO).toList();
    }

    public List<SimpleAssetDTO> getAssetByType(AssetEnumType type){
        List<AssetModel> model = assetRepository.findByType(type);

        return model.stream().map(AssetConverter::toAssetDTO).toList();
    }

    public SimpleAssetDTO createAsset(CreateAssetDTO createAssetDTO){

        AssetDomain domain = AssetConverter.toAssetDoamDomain(createAssetDTO);
        AssetModel model = AssetConverter.toAssetModel(domain);

        return AssetConverter.toAssetDTO(assetRepository.save(model));
    }

    public SimpleAssetDTO updateAssetPrice(UpdateAssetPriceDTO updateAssetPriceDTO){

        Optional<AssetModel> optional = assetRepository.findById(updateAssetPriceDTO.getId());
        AssetModel model = optional.get();

        UpdateAssetPriceUseCase useCase = new UpdateAssetPriceUseCase(model.getId(), updateAssetPriceDTO.getId(), model.getCurrentPrice(), updateAssetPriceDTO.getPriceModel());
        useCase.validate();

        model.setCurrentPrice(updateAssetPriceDTO.getNewPrice());

        return AssetConverter.toAssetDTO(assetRepository.save(model));
    }

    public void removeAsset(RemoveAssetDTO removeAssetDTO){
        Optional<AssetModel> optionalModel = assetRepository.findById(removeAssetDTO.id());

        assetRepository.delete(optionalModel.get());
    }
}