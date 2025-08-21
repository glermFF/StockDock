package ufop.edu.web.stockdock.User.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDomain {
    private UUID id;

    private String username;
    
    private String fullname;

    private String email;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
