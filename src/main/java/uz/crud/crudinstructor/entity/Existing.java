package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Existing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exist_id;


    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable(name = "student_exists",joinColumns = @JoinColumn(name = "exist_id"), inverseJoinColumns = @JoinColumn(name = "student_exist_id"))
    private List<StudentExisting> studentExisting;

    @JsonFormat(pattern="yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private String date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentClass_id")
    @JsonIgnore
    private  StudentClass studentClass;


    public Existing(Long exist_id, List<StudentExisting> studentExisting, String date, StudentClass studentClass) {
        this.exist_id = exist_id;
        this.studentExisting = studentExisting;
        this.date = date;
        this.studentClass = studentClass;
    }

    public Existing() {
    }
}
