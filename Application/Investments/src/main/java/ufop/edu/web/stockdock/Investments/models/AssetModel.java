package ufop.edu.web.stockdock.Investments.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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

    @Enumerated(EnumType.STRING)
    private AssetEnumType type;

    private Integer quantity;

    private Double purchasedPrice;

    private LocalDateTime purchasedAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void antesGravar() {
        this.purchasedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void antesAtualizar(){
        this.updatedAt = LocalDateTime.now();
    }
}
