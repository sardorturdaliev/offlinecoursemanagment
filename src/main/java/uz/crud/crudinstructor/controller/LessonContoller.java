package uz.crud.crudinstructor.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.LessonDto;
import uz.crud.crudinstructor.entity.Lesson;
import uz.crud.crudinstructor.service.LessonService;

import java.util.List;

@RestController
@RequestMapping("/lesson_operations")
public class LessonContoller {

    private LessonService lessonService;

    @Autowired
    public LessonContoller(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/create_Lesson")
    public ResponseEntity<String> createLesson(@RequestBody LessonDto lessonDto) {
        String result = lessonService.lessonCreate(lessonDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getAll_Lessons")
    public ResponseEntity<List<Lesson>> getAllLessons(@Schema(description = "Get By Class id",defaultValue = "0") @RequestParam Long class_id) {
        List<Lesson> list = lessonService.getAllLessson(class_id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
