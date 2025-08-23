package ufop.edu.web.stockdock.Investments.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.Investments.dtos.Assets.CreateAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.RemoveAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.SimpleAssetDTO;
import ufop.edu.web.stockdock.Investments.dtos.Assets.UpdateAssetPriceDTO;
import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;
import ufop.edu.web.stockdock.Investments.services.AssetService;

@RequestMapping("/ivestments_asset")
@RestController
@AllArgsConstructor
public class AssetController {
    
     private final AssetService assetService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Assets API running");
    }

    @GetMapping("/")
    public ResponseEntity<List<SimpleAssetDTO>> getAllAssets(){
        
        List<SimpleAssetDTO> assetList = assetService.getAllAssets();
        return ResponseEntity.ok(assetList);
    }

    @GetMapping("/by_type")
    public ResponseEntity<List<SimpleAssetDTO>> getAssetByType(@PathVariable(value = "type")AssetEnumType type){

        List<SimpleAssetDTO> assettype = assetService.getAssetByType(type);
        return ResponseEntity.ok(assettype);
    }

    @PostMapping("/invest-new-asset")
    public ResponseEntity<SimpleAssetDTO> createAsset(@RequestBody CreateAssetDTO createAssetDTO){

        SimpleAssetDTO assetDTO = assetService.createAsset(createAssetDTO);
        return ResponseEntity.ok(assetDTO);
    }

    @PutMapping("/update-price")
    public ResponseEntity<SimpleAssetDTO> updateAssetPrice(@RequestBody UpdateAssetPriceDTO updateAssetPriceDTO){

        SimpleAssetDTO assetDTO = assetService.updateAssetPrice(updateAssetPriceDTO);

        if(assetDTO == null){ return ResponseEntity.notFound().build(); }

        return ResponseEntity.ok(assetDTO);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> removeAsset(@RequestBody RemoveAssetDTO removeAssetDTO){
        assetService.removeAsset(removeAssetDTO);
        return ResponseEntity.ok("Asset have been removed\n" + removeAssetDTO);
    }
}
