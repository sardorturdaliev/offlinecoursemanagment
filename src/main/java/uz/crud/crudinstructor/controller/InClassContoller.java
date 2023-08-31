package uz.crud.crudinstructor.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.InClassDto;
import uz.crud.crudinstructor.dto.requestDto.PutInclassRequestDto;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.service.InClassService;

import java.util.List;

@RestController
@RequestMapping("/inclass")
public class InClassContoller {

    private InClassService service;


    @Autowired
    public InClassContoller(InClassService inClassService) {
        this.service = inClassService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody InClassDto inClassDto) {
        String result = service.createInClass(inClassDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<InClass>> getAll() {
        List<InClass> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getStudents/")
    public ResponseEntity<List<InClass>> getStudents(@Schema(defaultValue = "0") @RequestParam Long classId) {
        List<InClass> list = service.getClassStudent(classId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getStudent/{name}")
    public ResponseEntity<List<InClass>> getStudentByName(@PathVariable String name) {
        List<InClass> inClass = service.findByName(name);
        return new ResponseEntity<>(inClass, HttpStatus.OK);
    }

    @PutMapping("/getStudent")
    public ResponseEntity<InClass> editInclass(@RequestBody PutInclassRequestDto inClassDto) {
        InClass inClass = service.editInClass(inClassDto);
        return new ResponseEntity<>(inClass, HttpStatus.OK);
    }

}
