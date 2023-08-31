package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.StudentClassDto;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.entity.User;
import uz.crud.crudinstructor.repository.StudentClasssRepository;
import uz.crud.crudinstructor.repository.StudentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentClassService {
    private StudentClasssRepository studentRepository;
    private UserService userService;

    @Autowired
    public StudentClassService(StudentClasssRepository studentRepository, UserService userService) {
        this.studentRepository = studentRepository;
        this.userService = userService;
    }


    public String createClass(StudentClassDto studentClassDto) {
        if (studentRepository.findByclassname(studentClassDto.getClassname()) != null) {
            return "Already Exist";
        }
        StudentClass studentClass = new StudentClass();
        studentClass.setClassname(studentClassDto.getClassname());
        studentClass.setStatus(studentClassDto.getStatus());
        User user = userService.getUser(studentClassDto.getUser_id());
        studentClass.setUser(user);
        studentRepository.save(studentClass);
        return "Success";
    }
    public List<StudentClass> getAll() {
        List<StudentClass> studentClasses = studentRepository.findAll();
        return studentClasses;
    }
    public StudentClass getStudentClass(Long id) {
        Optional<StudentClass> studentClass = studentRepository.findById(id);
        return studentClass.get();
    }


}
