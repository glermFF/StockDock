package ufop.edu.web.stockdock.User.dtos;

import java.util.UUID;

public record SimpleUserRecordDTO(UUID id, String username, String fullname, String email, String password) {}