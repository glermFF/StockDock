package ufop.edu.web.stockdock.Wallet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Wallet.converter.WalletConverter;
import ufop.edu.web.stockdock.Wallet.dtos.SimpleWalletDTO;
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
}
