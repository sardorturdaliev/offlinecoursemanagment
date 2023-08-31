package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;

@Data
public class MessageDto {
    private Long user_id;
    private Long student_id;
    private String message;
}
