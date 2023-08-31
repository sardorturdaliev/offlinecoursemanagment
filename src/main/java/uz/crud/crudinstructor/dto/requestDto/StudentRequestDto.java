package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;
import uz.crud.crudinstructor.entity.Phone;

@Data
public class StudentRequestDto {
    private String name;
    private Phone phone;
}
