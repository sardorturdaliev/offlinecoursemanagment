package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.LessonDto;
import uz.crud.crudinstructor.entity.Lesson;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.repository.LessonRepositor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private LessonRepositor repositor;
    private StudentClassService studentClassService;


    @Autowired
    public LessonService(LessonRepositor repositor, StudentClassService studentClassService) {
        this.repositor = repositor;
        this.studentClassService = studentClassService;
    }


    public String lessonCreate(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonDto.getLessonName());
        StudentClass studentClass = studentClassService.getStudentClass(lessonDto.getClass_id());
        lesson.setStudentClassess(studentClass);
        repositor.save(lesson);
        return "Added";
    }

    public List<Lesson> getAllLessson(Long class_id) {
        List<Lesson> list = repositor.findAll();
        Collections.reverse(list);
        return list.stream().filter(classlist -> classlist.getStudentClassess().getId() == class_id).collect(Collectors.toList());
    }
    public Lesson getLessson(Long id) {
        Optional<Lesson> optionalLesson = repositor.findById(id);
        return optionalLesson.get();
    }



}
