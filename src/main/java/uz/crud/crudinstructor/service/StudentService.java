package uz.crud.crudinstructor.service;

import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.StudentRequestDto;
import uz.crud.crudinstructor.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    public String addStudent(Student student);
    public List<Student> getStudents();


}
