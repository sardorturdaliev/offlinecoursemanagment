package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String role;
    private Boolean status = true;
    private Long adminId;
    private String password;
}
