package uz.crud.crudinstructor.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import uz.crud.crudinstructor.entity.Homework;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.entity.Topics;

import java.util.Date;
import java.util.List;

@Data
public class HomeWorksResponse {
    private int sum;
    private List<Homework> homework;

    public HomeWorksResponse(int sum, List<Homework> homework) {
        this.sum = sum;
        this.homework = homework;
    }

    public HomeWorksResponse() {
    }
}
