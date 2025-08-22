package ufop.edu.web.stockdock.Wallet.domain.usecases;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateWalletNameUsecase {
    
    private UUID walletIdModel;
    private UUID walletIdPassed;
    private String walletNameModel;
    private String newWalletName;

    public void validate(){
        validateWalletId();
        validateWalletName();
    }

    public void validateWalletId(){
        if(!walletIdModel.equals(walletIdPassed)){
            throw new RuntimeException("No wallet found");
        }
    }

    public void validateWalletName(){
        if(walletNameModel.equals(newWalletName)){
            throw new RuntimeException("Name already in use");
        }
    }
}
