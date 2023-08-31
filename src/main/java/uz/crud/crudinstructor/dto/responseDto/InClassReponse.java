package uz.crud.crudinstructor.dto.responseDto;

import lombok.Data;

@Data
public class InClassReponse {
    private Long student_id;
    private String studentName;

    public InClassReponse(Long inclass_id, String studentName) {
        this.student_id = inclass_id;
        this.studentName = studentName;
    }
}
