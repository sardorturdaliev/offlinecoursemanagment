package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.LoginStudentDto;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.repository.InClassRepostiry;

import java.util.Objects;

@Service
public class LoginService {

    private final InClassRepostiry repostiry;

    @Autowired
    public LoginService(InClassRepostiry repostiry) {
        this.repostiry = repostiry;
    }


    public InClass loginIn(LoginStudentDto loginStudentDto) {// Sardor 123456
        InClass inClass = repostiry.findByname(loginStudentDto.getName());
        if (Objects.nonNull(inClass)) {
            if (inClass.getPassword().equals(loginStudentDto.getPassword())) {
                return inClass;
            }
        }
        return new InClass();
    }

}
