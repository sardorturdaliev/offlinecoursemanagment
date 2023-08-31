package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;

@Data
public class StudentClassDto {
    private String classname;
    private Boolean status = true;
    private Long user_id;
}
