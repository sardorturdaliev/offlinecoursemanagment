package uz.crud.crudinstructor.dto.responseDto;

import lombok.Data;

@Data
public class StudentClassResponse {
    private Long studentClass_id;
    private String studentClass_name;

    public StudentClassResponse(Long studentClass_id, String studentClass_name) {
        this.studentClass_id = studentClass_id;
        this.studentClass_name = studentClass_name;
    }
}
