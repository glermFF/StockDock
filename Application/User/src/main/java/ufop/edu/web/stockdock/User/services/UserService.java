package ufop.edu.web.stockdock.User.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.User.converters.UserConverter;
import ufop.edu.web.stockdock.User.domain.UserDomain;
import ufop.edu.web.stockdock.User.dtos.CreateUserDTO;
import ufop.edu.web.stockdock.User.dtos.SimpleUserRecordDTO;
import ufop.edu.web.stockdock.User.model.UserModel;
import ufop.edu.web.stockdock.User.repository.IUserRepo;

@Service
@AllArgsConstructor
public class UserService {

    private final IUserRepo userRepo;

    public List<SimpleUserRecordDTO> getAllUsers(){
        
        List<UserModel> userList = userRepo.findAll();

        return userList.stream().map(UserConverter::toUserRecordDTO).toList();
    }


    public SimpleUserRecordDTO createUser(CreateUserDTO createUserDTO) {

        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        UserModel userModel = UserConverter.toUserModel(userDomain);

        return UserConverter.toUserRecordDTO(userRepo.save(userModel));
    }
}
