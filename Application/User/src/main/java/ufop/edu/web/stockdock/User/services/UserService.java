package ufop.edu.web.stockdock.User.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.User.converters.UserConverter;
import ufop.edu.web.stockdock.User.domain.UserDomain;
import ufop.edu.web.stockdock.User.domain.usecases.UpdateUserEmailUseCase;
import ufop.edu.web.stockdock.User.dtos.CreateUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.DeleteUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.SimpleUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.UpdateUserDTO;
import ufop.edu.web.stockdock.User.dtos.UpdateUserEmailDTO;
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


    public SimpleUserRecordDTO createUser(CreateUserRecordDTO createUserDTO) {

        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);
        UserModel userModel = UserConverter.toUserModel(userDomain);


        return UserConverter.toUserRecordDTO(userRepo.save(userModel));
    }

    public SimpleUserRecordDTO updateUser(UpdateUserDTO updateUserDTO){

        UserDomain userDomain = UserConverter.toUserDomain(updateUserDTO);
        UserModel userModel = UserConverter.toUserModel(userDomain);

        Optional<UserModel> optionalList = userRepo.findById(updateUserDTO.getId());

        if(optionalList.isEmpty()){
            return null;
        }
    
        return UserConverter.toUserRecordDTO(userRepo.save(userModel));
    }

    public SimpleUserRecordDTO updateUserEmail(UpdateUserEmailDTO updateUserEmailDTO){
        
        Optional<UserModel> optionalModel = userRepo.findById(updateUserEmailDTO.getId());
        UserModel usermModel = optionalModel.get();

        UpdateUserEmailUseCase useCase = new UpdateUserEmailUseCase(usermModel.getEmail(), updateUserEmailDTO.getOldEmail());
        useCase.validate();

        usermModel.setEmail(updateUserEmailDTO.getNewEmail());
        
        return UserConverter.toUserRecordDTO(usermModel);

    }

    public void deleteUser(DeleteUserRecordDTO deleteUserRecordDTO){
        Optional<UserModel> optionalModel = userRepo.findById(deleteUserRecordDTO.id());

        userRepo.delete(optionalModel.get());
    }
}
