package uz.crud.crudinstructor.dto.requestDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.entity.Lesson;
import uz.crud.crudinstructor.entity.User;

@Data
public class MarksDto {
    private int mark;
    private Long lesson_id;
    private Long inclass_id;
}
