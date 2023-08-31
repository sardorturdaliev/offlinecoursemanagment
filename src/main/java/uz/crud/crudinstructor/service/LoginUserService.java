package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.UserDto;
import uz.crud.crudinstructor.entity.LoginUser;
import uz.crud.crudinstructor.entity.User;
import uz.crud.crudinstructor.repository.LoginUserRepository;
import uz.crud.crudinstructor.repository.UserRepository;

import java.util.Objects;

@Service
public class LoginUserService {
    private LoginUserRepository userRepository;

    @Autowired
    public LoginUserService(LoginUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginIn(LoginUser loginUser) {// Mr Lee
        User user = userRepository.findByusername(loginUser.getUsername().trim());
        if (Objects.nonNull(user)) {
            if (user.getPassword().equals(loginUser.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
