package uz.crud.crudinstructor.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.entity.MarkStudent;
import uz.crud.crudinstructor.entity.MarkStudentSum;
import uz.crud.crudinstructor.service.MarkStudentService;
import uz.crud.crudinstructor.service.MarksService;

import java.util.List;

@RestController
@RequestMapping("/mark_Student")
public class MarkStudentContoller {

    private MarkStudentService markStudentService;

    @Autowired
    public MarkStudentContoller(MarkStudentService markStudentService) {
        this.markStudentService = markStudentService;
    }


    @GetMapping("/getStudents_Marks")
    public ResponseEntity<List<MarkStudent>> getStudentMarkByHomeWork(@RequestParam Long homework_id) {
        List<MarkStudent> markStudentList = markStudentService.getMarksbyHomeWork(homework_id);
        return new ResponseEntity<>(markStudentList, HttpStatus.OK);
    }


    @PutMapping("/update_Student_Marks")
    public ResponseEntity<MarkStudent> updateMarkStudent(@RequestBody MarkStudent markStudent) {
        MarkStudent updatemark = markStudentService.edit(markStudent);
        return new ResponseEntity<>(updatemark, HttpStatus.OK);
    }



    @GetMapping("/getRating")
    public ResponseEntity<List<MarkStudent>> getRating(@RequestParam Long studentClass_id) {
        List<MarkStudent> list = markStudentService.getMarkStudentOrder(studentClass_id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/get_marked_student_sum")
    public ResponseEntity<MarkStudentSum> getmarkedStudentSum(@Schema(description = "Get Marked Student",defaultValue = "0") @RequestParam Long homeworkId){
        MarkStudentSum markStudentSum = markStudentService.getMarkedStudentSum(homeworkId);
        return new ResponseEntity<>(markStudentSum,HttpStatus.OK);
    }


    @GetMapping("/getStudent_max_ball")
    public ResponseEntity<MarkStudent> getmaxballStudent(@RequestParam Long studentClassId){
        MarkStudent markStudentList = markStudentService.getMaxBallStudent(studentClassId);
        return new ResponseEntity<>(markStudentList,HttpStatus.OK);
    }




}
