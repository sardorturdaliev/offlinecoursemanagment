package uz.crud.crudinstructor.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.StudentRequestDto;
import uz.crud.crudinstructor.entity.Phone;
import uz.crud.crudinstructor.entity.Student;
import uz.crud.crudinstructor.service.PhoneService;
import uz.crud.crudinstructor.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentContoller {
    private StudentService studentService;


    @Autowired
    public StudentContoller(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student studentRequestDto) {
        String result = studentService.addStudent(studentRequestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> list = studentService.getStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }




}
