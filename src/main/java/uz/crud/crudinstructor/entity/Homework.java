package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long homework_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topics topics;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentClass_id")
    @JsonIgnore
    private StudentClass studentClass;

    private String homeworkmessage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String deadline;
    @JsonFormat(pattern="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String createddate;


    private int markedStudentSum;
    private int maxStudent;


    public Homework(Long homework_id,Topics topics, StudentClass studentClass, String homeworkmessage, String deadline, String createddate,int maxStudent, int markedStudentSum) {
        this.homework_id = homework_id;
        this.topics = topics;
        this.studentClass = studentClass;
        this.homeworkmessage = homeworkmessage;
        this.deadline = deadline;
        this.createddate = createddate;
        this.maxStudent = maxStudent;
        this.markedStudentSum = markedStudentSum;
    }



    public Homework() {
    }
}
