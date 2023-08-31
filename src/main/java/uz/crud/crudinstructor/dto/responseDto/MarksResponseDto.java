package uz.crud.crudinstructor.dto.responseDto;

import lombok.Data;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.entity.Lesson;

@Data
public class MarksResponseDto {
    private int mark;
    private LessonResponse lessonResponse;
    private InClassReponse inClassResponse;
    private StudentClassResponse studentClassResponse;


    public MarksResponseDto(int mark, LessonResponse lessonResponse, InClassReponse inClassResponse, StudentClassResponse studentClassResponse) {
        this.mark = mark;
        this.lessonResponse = lessonResponse;
        this.inClassResponse = inClassResponse;
        this.studentClassResponse = studentClassResponse;
    }
}


