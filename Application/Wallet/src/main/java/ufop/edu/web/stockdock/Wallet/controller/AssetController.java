package ufop.edu.web.stockdock.Wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/sd_assets")
@RestController
@AllArgsConstructor
public class AssetController {
    
    // private final AssetService assetService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Assets API running");
    }
}
