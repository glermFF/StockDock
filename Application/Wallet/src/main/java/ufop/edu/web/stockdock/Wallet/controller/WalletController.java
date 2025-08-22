package ufop.edu.web.stockdock.Wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufop.edu.web.stockdock.Wallet.services.WalletService;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Wallet.dtos.CreateWalletDTO;
import ufop.edu.web.stockdock.Wallet.dtos.SimpleWalletDTO;

@RequestMapping("/sd_wallets")
@RestController
@AllArgsConstructor
public class WalletController {
    
    private final WalletService walletService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Serviço de Carteiras rodando");
    }

    @PostMapping
    public ResponseEntity<SimpleWalletDTO> createWallet(@RequestBody CreateWalletDTO createWalletDTO){
        
        SimpleWalletDTO walletDTO = walletService.createWallet(createWalletDTO);
        return ResponseEntity.ok(walletDTO);
    }
}
