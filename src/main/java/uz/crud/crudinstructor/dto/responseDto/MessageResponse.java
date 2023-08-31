package uz.crud.crudinstructor.dto.responseDto;

import lombok.Data;

@Data
public class MessageResponse {
    private Long message_id;
    private String message;
    private String teacher_name;

    public MessageResponse(Long message_id, String message, String teacher_name) {
        this.message_id = message_id;
        this.message = message;
        this.teacher_name = teacher_name;
    }
}
