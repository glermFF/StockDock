package ufop.edu.web.stockdock.User.converters;

import lombok.NoArgsConstructor;
import ufop.edu.web.stockdock.User.domain.UserDomain;
import ufop.edu.web.stockdock.User.dtos.CreateUserDTO;
import ufop.edu.web.stockdock.User.dtos.SimpleUserRecordDTO;
import ufop.edu.web.stockdock.User.model.UserModel;

@NoArgsConstructor
public class UserConverter {
    // record --> model
    public static SimpleUserRecordDTO toUserRecordDTO(UserModel userModel){
        return new SimpleUserRecordDTO(userModel.getId(), userModel.getUsername(), userModel.getFullname(), userModel.getEmail(), userModel.getPassword()); //! acrescentar WalletModel
    }
    // model --> domain
    public static UserModel toUserModel(UserDomain userDomain){
        return UserModel.builder().id(userDomain.getId()).username(userDomain.getFullname()).fullname(userDomain.getFullname()).email(userDomain.getEmail()).password(userDomain.getPassword()).build(); //! acrescentar WalletModel
    }
    // domain --> requisitions
    public static UserDomain toUserDomain(CreateUserDTO createUserDTO){
        return UserDomain.builder().id(createUserDTO.id()).username(createUserDTO.username()).fullname(createUserDTO.fullname()).email(createUserDTO.email()).password(createUserDTO.password()).build();
    }
}
