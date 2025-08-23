package ufop.edu.web.stockdock.Investments.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;
import ufop.edu.web.stockdock.Investments.models.AssetModel;

public interface IAssetRepository extends JpaRepository <AssetModel, UUID>{
    
    List<AssetModel> findByType(AssetEnumType type);
    // List<AssetModel> findByHigherPrice(Double price);
    // List<AssetModel> findByLowerPrice(Double price);
}
