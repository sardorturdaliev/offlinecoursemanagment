package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MarkStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long markstudent_id;
    private String name;
    private Integer ball;
    private Integer jeneralball;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_work_id")
    @JsonIgnore
    private Homework homework;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_class_id")
    @JsonIgnore
    private StudentClass studentClass;


    public MarkStudent(String name, Integer ball, Homework homework, Integer jeneralball,StudentClass studentClass) {
        this.name = name;
        this.ball = ball;
        this.homework = homework;
        this.jeneralball = jeneralball;
        this.studentClass = studentClass;
    }

    public MarkStudent() {
    }
}
