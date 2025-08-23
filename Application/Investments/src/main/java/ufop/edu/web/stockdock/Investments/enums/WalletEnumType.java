package ufop.edu.web.stockdock.Investments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WalletEnumType {
    
    PESSOAL(1, "Carteira Pessoal"),
    EMPRESARIAL(2, "Carteira Empressarial"),
    CONJUNTA(3, "Carteira Conjunta"),
    INVESTIMENTO(4, "Carteira de Investimentos");

    private Integer id;
    private String description;
}
