package ufop.edu.web.stockdock.Investments.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Investments.converters.AssetConverter;
import ufop.edu.web.stockdock.Investments.converters.WalletConverter;
import ufop.edu.web.stockdock.Investments.domains.WalletDomain;
import ufop.edu.web.stockdock.Investments.domains.usecases.UpdateWalletNameUsecase;
import ufop.edu.web.stockdock.Investments.dtos.CreateWalletDTO;
import ufop.edu.web.stockdock.Investments.dtos.DeleteWalletDTO;
import ufop.edu.web.stockdock.Investments.dtos.SimpleWalletDTO;
import ufop.edu.web.stockdock.Investments.dtos.UpdateWalletDTO;
import ufop.edu.web.stockdock.Investments.dtos.UpdateWalletName;
import ufop.edu.web.stockdock.Investments.models.WalletModel;
import ufop.edu.web.stockdock.Investments.repositories.IWalletRepository;

@Service
@AllArgsConstructor
public class WalletService {
    
    private final IWalletRepository walletRepository;

    public List<SimpleWalletDTO> getAllWallets(){
        
        List<WalletModel> walletList = walletRepository.findAll();

        return walletList.stream().map(WalletConverter::toWalletDTO).toList();
    }

    public SimpleWalletDTO createWallet(CreateWalletDTO createWalletDTO){

        WalletDomain domain = WalletConverter.toWalletDomain(createWalletDTO);
        WalletModel model = WalletConverter.toWalletModel(domain);

        return WalletConverter.toWalletDTO(walletRepository.save(model));
    }

    public SimpleWalletDTO updateWallet(UpdateWalletDTO updateWalletDTO){

        Optional<WalletModel> optional = walletRepository.findById(updateWalletDTO.getId());

        WalletModel model = optional.get();
        if (updateWalletDTO.getAssets() != null) {
            model.setAssets(updateWalletDTO.getAssets().stream().map(AssetConverter::toAssetModel).toList());
        }

        model.setUpdatedAt(updateWalletDTO.getUpdatedAt() != null ? updateWalletDTO.getUpdatedAt() : java.time.LocalDateTime.now());

        WalletModel updated = walletRepository.save(model);
        return WalletConverter.toWalletDTO(updated);
    }

    public SimpleWalletDTO updateWalletName(UpdateWalletName updateWalletName){

        Optional<WalletModel> optional = walletRepository.findById(updateWalletName.getId());

        WalletModel model = optional.get();

        UpdateWalletNameUsecase usecase = new UpdateWalletNameUsecase(model.getId(), updateWalletName.getId(), model.getWalletName(), updateWalletName.getWalletNameModel());
        usecase.validate();

        model.setWalletName(updateWalletName.getNewWalletName());

        return WalletConverter.toWalletDTO(walletRepository.save(model));
    }

    public void removeWallet(DeleteWalletDTO deleteWalletDTO){
        Optional<WalletModel> optionalModel = walletRepository.findById(deleteWalletDTO.id());
        
        walletRepository.delete(optionalModel.get());
    }
}
