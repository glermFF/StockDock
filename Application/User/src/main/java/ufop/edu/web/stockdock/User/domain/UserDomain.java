package ufop.edu.web.stockdock.User.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain {
    private UUID id;

    private String username;
    
    private String fullname;

    private String email;

    private String password;

    // private WalletModel walletModel;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
