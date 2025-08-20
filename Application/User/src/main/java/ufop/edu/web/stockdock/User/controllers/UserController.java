package ufop.edu.web.stockdock.User.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ufop.edu.web.stockdock.User.dtos.CreateUserDTO;
import ufop.edu.web.stockdock.User.dtos.SimpleUserRecordDTO;
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

        List<SimpleUserRecordDTO> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    } 

    
    @PostMapping
    public ResponseEntity<SimpleUserRecordDTO> createUser(@RequestBody CreateUserDTO createUserDTO){
            SimpleUserRecordDTO userDto = userService.createUser(createUserDTO);
            return ResponseEntity.ok(userDto);
    }
    
}
