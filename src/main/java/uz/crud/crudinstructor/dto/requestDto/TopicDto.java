package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;
import uz.crud.crudinstructor.entity.Lesson;

import java.time.LocalDate;

@Data
public class TopicDto {
    private String topicName;
    private Long lesson_id;
    private LocalDate date;
}
