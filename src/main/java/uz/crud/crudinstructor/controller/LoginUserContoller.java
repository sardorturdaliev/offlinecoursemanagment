package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.crud.crudinstructor.entity.LoginUser;
import uz.crud.crudinstructor.entity.User;
import uz.crud.crudinstructor.repository.LoginUserRepository;
import uz.crud.crudinstructor.service.LoginUserService;

@RestController
@RequestMapping("/login_user")
public class LoginUserContoller {
    private LoginUserService service;

    @Autowired
    public LoginUserContoller(LoginUserService service) {
        this.service = service;
    }


    @PostMapping("/login_user")
    public ResponseEntity<User> loginId(@RequestBody LoginUser loginUser) {
        User user = service.loginIn(loginUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
