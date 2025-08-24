package ufop.edu.web.stockdock.Investments.converters;

import lombok.NoArgsConstructor;
import ufop.edu.web.stockdock.Investments.domains.WalletDomain;
import ufop.edu.web.stockdock.Investments.dtos.CreateWalletDTO;
import ufop.edu.web.stockdock.Investments.dtos.SimpleWalletDTO;
import ufop.edu.web.stockdock.Investments.dtos.UpdateWalletName;
import ufop.edu.web.stockdock.Investments.models.WalletModel;

@NoArgsConstructor
public class WalletConverter {
    
    public static SimpleWalletDTO toWalletDTO(WalletModel walletModel){
        return new SimpleWalletDTO(walletModel.getId(), walletModel.getWalletName(), walletModel.getType(), walletModel.getAssets().stream().map(AssetConverter::toAssetDTO).toList());
    }

    public static WalletModel toWalletModel(WalletDomain walletDomain){
        return WalletModel.builder().id(walletDomain.getId()).walletName(walletDomain.getWalletName()).type(walletDomain.getType()).assets(new java.util.ArrayList<>()).build();
    }

    public static WalletDomain toWalletDomain(CreateWalletDTO createWalletDTO){
        return WalletDomain.builder().walletName(createWalletDTO.walletName()).type(createWalletDTO.type()).build();
    }

    public static WalletDomain toWalletDomain(UpdateWalletName updateWalletName){
        return WalletDomain.builder().id(updateWalletName.getId()).walletName(updateWalletName.getWalletNameModel()).build();
    }
}
