package ufop.edu.web.stockdock.Wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
// import ufop.edu.web.stockdock.Wallet.services.WalletService;

@RequestMapping("/sd_wallets")
@RestController
@AllArgsConstructor
public class WalletController {
    
    // private final WalletService walletService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Serviço de Carteiras rodando");
    }
}
