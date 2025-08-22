package ufop.edu.web.stockdock.User.converters;

import lombok.NoArgsConstructor;
import ufop.edu.web.stockdock.User.domain.UserDomain;
import ufop.edu.web.stockdock.User.dtos.CreateUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.SimpleUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.UpdateUserDTO;
import ufop.edu.web.stockdock.User.model.UserModel;

@NoArgsConstructor
public class UserConverter {
    // record --> model
    public static SimpleUserRecordDTO toUserRecordDTO(UserModel userModel){
        return new SimpleUserRecordDTO(userModel.getId(), userModel.getUsername(), userModel.getFullname(), userModel.getEmail(), userModel.getPassword());
    }
    // model --> domain
    public static UserModel toUserModel(UserDomain userDomain){
        return UserModel.builder().id(userDomain.getId()).username(userDomain.getUsername()).fullname(userDomain.getFullname()).email(userDomain.getEmail()).password(userDomain.getPassword()).build();
    }
    // domain --> requisitions
    public static UserDomain toUserDomain(CreateUserRecordDTO createUserDTO){
        return UserDomain.builder().username(createUserDTO.username()).fullname(createUserDTO.fullname()).email(createUserDTO.email()).password(createUserDTO.password()).build();
    }

    public static UserDomain toUserDomain(UpdateUserDTO updateUserDTO){
        return UserDomain.builder().id(updateUserDTO.getId()).username(updateUserDTO.getUsername()).fullname(updateUserDTO.getFullname()).email(updateUserDTO.getEmail()).password(updateUserDTO.getPassword()).build();
    }
}
