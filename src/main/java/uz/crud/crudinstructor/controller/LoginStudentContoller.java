package uz.crud.crudinstructor.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.crud.crudinstructor.dto.requestDto.LoginStudentDto;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.service.LoginService;

@RestController
@RequestMapping("/loginStudent")
public class LoginStudentContoller {
    private LoginService loginService;


    @Autowired
    public LoginStudentContoller(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<InClass> loginStudent(@RequestBody LoginStudentDto loginStudentDto) {
        InClass inClass = loginService.loginIn(loginStudentDto);
        return new ResponseEntity<>(inClass, HttpStatus.OK);
    }

}
