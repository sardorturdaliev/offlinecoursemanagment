package uz.crud.crudinstructor.dto.requestDto;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import uz.crud.crudinstructor.entity.StudentClass;

@Data
public class InClassDto {
    private String name;
    private Long studentclassid;
    private String password;
    private Boolean status = true;


    private Boolean present = false;



}
