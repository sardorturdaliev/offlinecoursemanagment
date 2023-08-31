package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.entity.Student;
import uz.crud.crudinstructor.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public String addStudent(Student studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setPhone(studentRequestDto.getPhone());
        studentRepository.save(studentRequestDto);
        return "Success";
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll();
        return students;
    }


}
