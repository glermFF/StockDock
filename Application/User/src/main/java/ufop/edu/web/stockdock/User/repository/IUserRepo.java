package ufop.edu.web.stockdock.User.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ufop.edu.web.stockdock.User.model.UserModel;

public interface IUserRepo extends JpaRepository<UserModel, UUID>{
    
    List<UserModel> findByUsername(String username);
}
