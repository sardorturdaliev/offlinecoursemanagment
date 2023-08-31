package uz.crud.crudinstructor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.StudentClassDto;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.service.StudentClassService;
import uz.crud.crudinstructor.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/studentClass")
public class StudetClassController {

    private StudentClassService service;

    @Autowired
    public StudetClassController(StudentClassService service) {
        this.service = service;
    }

    @PostMapping("/create_class")
    public ResponseEntity<String> createClass(@RequestBody StudentClassDto studentClassDto) {
        String result = service.createClass(studentClassDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentClass>> getAll() {
        List<StudentClass> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
