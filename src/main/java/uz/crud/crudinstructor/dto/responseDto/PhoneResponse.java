package uz.crud.crudinstructor.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import uz.crud.crudinstructor.entity.Phone;

@Getter
@Setter
public class PhoneResponse {
    private Long id;
    private String number;
    private Phone phone;
}
