package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;
import uz.crud.crudinstructor.dto.requestDto.MarksDto;
import uz.crud.crudinstructor.dto.responseDto.InClassReponse;
import uz.crud.crudinstructor.dto.responseDto.LessonResponse;
import uz.crud.crudinstructor.dto.responseDto.MarksResponseDto;
import uz.crud.crudinstructor.dto.responseDto.StudentClassResponse;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.entity.Lesson;
import uz.crud.crudinstructor.entity.Marks;
import uz.crud.crudinstructor.repository.MarksReposotory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarksService {
    private MarksReposotory reposotory;
    private LessonService lessonService;
    private InClassService inClassService;


    @Autowired
    public MarksService(MarksReposotory reposotory, LessonService lessonService, InClassService inClassService) {
        this.reposotory = reposotory;
        this.lessonService = lessonService;
        this.inClassService = inClassService;
    }


    public String addMark(MarksDto marksDto) {
        Marks marks = new Marks();
        marks.setMark(marksDto.getMark());
        Lesson lesson = lessonService.getLessson(marksDto.getLesson_id());
        InClass inClass = inClassService.getInClass(marksDto.getInclass_id());
        marks.setLesson(lesson);
        marks.setStudentClass(inClass);
        reposotory.save(marks);
        return "Success";
    }


    public List<MarksResponseDto> getallMarks() {
        List<Marks> list = reposotory.findAll();
        List<MarksResponseDto> marksResponseDtoList = new ArrayList<>();
        for (Marks marks : list) {
            LessonResponse lessonResponse = new LessonResponse(marks.getLesson().getLessonid(), marks.getLesson().getLessonName());
            InClassReponse inClassReponse = new InClassReponse(marks.getStudentClass().getId(), marks.getStudentClass().getName());
            StudentClassResponse studentClassResponse = new StudentClassResponse(marks.getLesson().getStudentClassess().getId(), marks.getLesson().getStudentClassess().getClassname());
            MarksResponseDto responseDto = new MarksResponseDto(marks.getMark(), lessonResponse, inClassReponse, studentClassResponse);
            marksResponseDtoList.add(responseDto);
        }
        return marksResponseDtoList;
    }

    public List<MarksResponseDto> getMarks(Long classid) {//2
        List<Marks> list = reposotory.findAll();
        List<MarksResponseDto> marksResponseDtoList = new ArrayList<>();
        for (Marks marks : list) {
            LessonResponse lessonResponse = new LessonResponse(marks.getLesson().getLessonid(), marks.getLesson().getLessonName());
            InClassReponse inClassReponse = new InClassReponse(marks.getStudentClass().getId(), marks.getStudentClass().getName());
            StudentClassResponse studentClassResponse = new StudentClassResponse(marks.getLesson().getStudentClassess().getId(), marks.getLesson().getStudentClassess().getClassname());
            MarksResponseDto responseDto = new MarksResponseDto(marks.getMark(), lessonResponse, inClassReponse, studentClassResponse);
            marksResponseDtoList.add(responseDto);
        }

        if (classid != null) {
            return marksResponseDtoList.stream().filter((mlist) -> mlist.getStudentClassResponse().getStudentClass_id().equals(classid)).collect(Collectors.toList());
        }

        return marksResponseDtoList;
    }


}
