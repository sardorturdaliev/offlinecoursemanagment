package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_id;
    private String topicName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;


    @ManyToOne()
    @JoinColumn(name = "lesson_id")
    @JsonIgnore
    Lesson lesson;


}
