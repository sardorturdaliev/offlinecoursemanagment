package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.UserDto;
import uz.crud.crudinstructor.entity.User;
import uz.crud.crudinstructor.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/create_user")
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        String result = userService.createUser(userDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers(){
        List<User> getUsers = userService.getAllUsers();
        return new ResponseEntity<>(getUsers,HttpStatus.OK);
    }

}
