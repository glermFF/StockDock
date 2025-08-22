package ufop.edu.web.stockdock.Wallet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufop.edu.web.stockdock.Wallet.services.WalletService;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Wallet.dtos.CreateWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.DeleteWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.SimpleWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.UpdateWalletName;

@RequestMapping("/sd_wallets")
@RestController
@AllArgsConstructor
public class WalletController {
    
    private final WalletService walletService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Serviço de Carteiras rodando");
    }

    @GetMapping("/all-wallets")
    public ResponseEntity<List<SimpleWalletDTO>> getAllWallets(){
        
        List<SimpleWalletDTO> walletList = walletService.getAllWallets();
        return ResponseEntity.ok(walletList);
    }
 
    @PostMapping("/")
    public ResponseEntity<SimpleWalletDTO> createWallet(@RequestBody CreateWalletDTO createWalletDTO){
        
        SimpleWalletDTO walletDTO = walletService.createWallet(createWalletDTO);
        return ResponseEntity.ok(walletDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<SimpleWalletDTO> updateWalletName(@RequestBody UpdateWalletName updateWalletName){

        SimpleWalletDTO walletDTO = walletService.updateWalletName(updateWalletName);

        if(walletDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(walletDTO);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> removeWallet(@RequestBody DeleteWalletDTO deleteWalletDTO){

        walletService.removeWallet(deleteWalletDTO);
        return ResponseEntity.ok("Wallet Removed from the list");
    }
}
