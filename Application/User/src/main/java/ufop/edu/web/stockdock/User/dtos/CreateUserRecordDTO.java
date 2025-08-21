package ufop.edu.web.stockdock.User.dtos;

import java.util.UUID;

public record CreateUserRecordDTO(UUID id, String username, String fullname, String email, String password) {}