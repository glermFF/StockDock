package ufop.edu.web.stockdock.Investments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AssetEnumType {
    
    CRIPTO(1, "Cripto Moeda"),
    ACAO(2, "Ação"),
    FII(3, "Fundo de Investimentos");

    private Integer id;
    private String description;

}
