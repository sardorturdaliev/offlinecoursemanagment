package uz.crud.crudinstructor.dto.responseDto;

import lombok.Data;

@Data
public class LessonResponse {
    private Long lesson_id;
    private String lesson_name;

    public LessonResponse(Long lesson_id, String lesson_name) {
        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
    }
}
