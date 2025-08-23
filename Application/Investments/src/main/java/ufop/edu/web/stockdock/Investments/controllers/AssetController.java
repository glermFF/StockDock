package ufop.edu.web.stockdock.Investments.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Investments.dtos.Assets.CreateAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.RemoveAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.services.AssetService;

@RequestMapping("/sd_assets")
@RestController
@AllArgsConstructor
public class AssetController {
    
     private final AssetService assetService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Assets API running");
    }

    @PostMapping("/")
    public ResponseEntity<SimpleAssetDTO> createAsset(@RequestBody CreateAssetDTO createAssetDTO){

        SimpleAssetDTO assetDTO = assetService.createAsset(createAssetDTO);
        return ResponseEntity.ok(assetDTO);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> removeAsset(@RequestBody RemoveAssetDTO removeAssetDTO){
        assetService.removeAsset(removeAssetDTO);
        return ResponseEntity.ok("Asset have been removed\n" + removeAssetDTO);
    }
}
