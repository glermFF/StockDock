package ufop.edu.web.stockdock.Wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Wallet.converter.WalletConverter;
import ufop.edu.web.stockdock.Wallet.domain.WalletDomain;
import ufop.edu.web.stockdock.Wallet.domain.usecases.UpdateWalletNameUsecase;
import ufop.edu.web.stockdock.Wallet.dtos.CreateWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.DeleteWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.SimpleWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.UpdateWalletName;
import ufop.edu.web.stockdock.Wallet.enums.WalletEnumType;
import ufop.edu.web.stockdock.Wallet.model.WalletModel;
import ufop.edu.web.stockdock.Wallet.repo.IWalletRepository;

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

        // model.setType(WalletEnumType.INVESTIMENTO);

        return WalletConverter.toWalletDTO(walletRepository.save(model));
    }

    public SimpleWalletDTO updateWalletName(UpdateWalletName updateWalletName){

        Optional<WalletModel> optional = walletRepository.findById(updateWalletName.getId());

        WalletModel model = optional.get();

        UpdateWalletNameUsecase usecase = new UpdateWalletNameUsecase(model.getId(), updateWalletName.getId(), model.getWalletName(), updateWalletName.getWalletNameModel());
        usecase.validate();

        model.setWalletName(updateWalletName.getNewWalletName());

        return WalletConverter.toWalletDTO(model);
    }

    public void deleteWallet(DeleteWalletDTO deleteWalletDTO){
        Optional<WalletModel> optionalModel = walletRepository.findById(deleteWalletDTO.id());
        
        walletRepository.delete(optionalModel.get());
    }
}
