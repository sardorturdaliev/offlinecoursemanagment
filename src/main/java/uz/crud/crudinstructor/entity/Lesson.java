package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonid;
    private String lessonName;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentClass_id")
    @JsonIgnore
    private StudentClass studentClassess;




}
