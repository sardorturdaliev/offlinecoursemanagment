package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mark_id;
    private int mark;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    @JsonIgnore
    private Lesson lesson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inclass_id")
    @JsonIgnore
    private InClass studentClass;







}
