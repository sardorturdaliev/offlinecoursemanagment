package uz.crud.crudinstructor.dto.requestDto;

import jakarta.persistence.*;
import lombok.Data;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.entity.Topics;

import java.util.Date;

@Data
public class HomeWorkDto {
    private Long topics_id;
    private Long studentClass_id;
    private String homeworkmessage;
    private String deadline;
    private String createddate;
}
