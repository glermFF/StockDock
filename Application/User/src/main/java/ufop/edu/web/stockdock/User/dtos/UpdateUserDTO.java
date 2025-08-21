package ufop.edu.web.stockdock.User.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    
    private UUID id;

    private String username;
    
    private String fullname;

    private String email;

    private String password;

    private LocalDateTime updatedAt;
}
