package ufop.edu.web.stockdock.Investments.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ufop.edu.web.stockdock.Investments.models.WalletModel;

public interface IWalletRepository extends JpaRepository<WalletModel, UUID>{
    
    List<WalletModel> findByWalletName(String walletName);
}
