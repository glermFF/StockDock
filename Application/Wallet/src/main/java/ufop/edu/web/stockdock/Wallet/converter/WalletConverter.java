package ufop.edu.web.stockdock.Wallet.converter;

import lombok.NoArgsConstructor;
import ufop.edu.web.stockdock.Wallet.domain.WalletDomain;
import ufop.edu.web.stockdock.Wallet.dtos.SimpleWalletDTO;
import ufop.edu.web.stockdock.Wallet.model.WalletModel;

@NoArgsConstructor
public class WalletConverter {
    
    public static SimpleWalletDTO toWalletDTO(WalletModel walletModel){
        return new SimpleWalletDTO(walletModel.getId(), walletModel.getWalletName(), walletModel.getType());
    }

    public static WalletModel toWalletModel(WalletDomain walletDomain){
        return WalletModel.builder().id(walletDomain.getId()).walletName(walletDomain.getWalletName()).type(walletDomain.getType()).build();
    }

    // public static WalletDomain toWalletDomain(){

    // }
}
