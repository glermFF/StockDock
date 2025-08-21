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
public class UpdateUserEmailDTO {
    
    private UUID id;

    private String username;

    private String newEmail;
    private String oldEmail;

    private LocalDateTime updatedAt;
}
