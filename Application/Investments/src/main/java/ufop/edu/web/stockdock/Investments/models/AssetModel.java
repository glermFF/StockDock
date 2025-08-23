package ufop.edu.web.stockdock.Investments.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufop.edu.web.stockdock.Investments.enums.AssetEnumType;

@Entity
@Table(name = "assets_tb")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private AssetEnumType type;

    private Double currentPrice;

    private LocalDateTime purchasedAt;

    @PrePersist
    public void antesGravar() {
        this.purchasedAt = LocalDateTime.now();
    }
}
