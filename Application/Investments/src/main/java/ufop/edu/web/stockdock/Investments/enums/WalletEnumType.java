package ufop.edu.web.stockdock.Investments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WalletEnumType {
    
    CRIPTOS(1, "Carteira de Criptos"),
    ACOES(2, "Carteira de Ações"),
    PERSONALIZADA(3, "Carteira Personalizada"),
    INVESTIMENTOS(4, "Carteira de Investimentos");

    private Integer id;
    private String description;
}
