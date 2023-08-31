package uz.crud.crudinstructor.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import uz.crud.crudinstructor.entity.StudentExisting;

import java.util.List;

@Data
public class ExistingDto {
    private List<StudentExisting> student_existing;
    @JsonFormat(pattern="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String date;
    private Long studentClass_id;
}
