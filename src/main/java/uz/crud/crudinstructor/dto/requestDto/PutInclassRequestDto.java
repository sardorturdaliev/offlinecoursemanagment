package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;

@Data
public class PutInclassRequestDto {
    private Long id;
    private String name;
    private Long studentclassid;
    private String password;
    private Boolean status = true;
}
