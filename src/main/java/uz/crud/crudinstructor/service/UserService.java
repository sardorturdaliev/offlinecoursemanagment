package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.crud.crudinstructor.dto.requestDto.UserDto;
import uz.crud.crudinstructor.entity.Admin;
import uz.crud.crudinstructor.entity.CreateUser;
import uz.crud.crudinstructor.entity.User;
import uz.crud.crudinstructor.repository.AdminRepository;
import uz.crud.crudinstructor.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private AdminService adminService;

    @Autowired
    public UserService(UserRepository userRepository, AdminService adminService) {
        this.userRepository = userRepository;
        this.adminService = adminService;
    }

    public String createUser(UserDto user) {
        User createUser = new User();
        createUser.setUsername(user.getUsername().trim());
        createUser.setStatus(user.getStatus());
        createUser.setRole(user.getRole());
        createUser.setPassword(user.getPassword().trim());
        Admin admin = adminService.getAdmin(user.getAdminId());
        createUser.setAdmin(admin);
        userRepository.save(createUser);
        return "Success";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }


}
