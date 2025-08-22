package ufop.edu.web.stockdock.User.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.User.dtos.CreateUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.DeleteUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.SimpleUserRecordDTO;
import ufop.edu.web.stockdock.User.dtos.UpdateUserDTO;
import ufop.edu.web.stockdock.User.services.UserService;

@RestController
@RequestMapping("/sd_users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Servidor rodadndo");
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<SimpleUserRecordDTO>> getAllUsers(){

        List<SimpleUserRecordDTO> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    } 

    
    @PostMapping("/")
    public ResponseEntity<SimpleUserRecordDTO> createUser(@RequestBody CreateUserRecordDTO createUserDTO){
        
        SimpleUserRecordDTO userDto = userService.createUser(createUserDTO);
        return ResponseEntity.ok(userDto);
    }
    
    @PutMapping("/update")
    public ResponseEntity<SimpleUserRecordDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO){

        SimpleUserRecordDTO userRecord = userService.updateUser(updateUserDTO);

        if(userRecord == null){
            System.out.println("Not user not found");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecord);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(@RequestBody DeleteUserRecordDTO deleteUserRecordDTO){

        userService.deleteUser(deleteUserRecordDTO);
        return ResponseEntity.ok("Usuário foi removido");
    }
}
