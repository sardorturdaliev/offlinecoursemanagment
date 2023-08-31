package uz.crud.crudinstructor.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
@Data
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "student_name")
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    @MapsId
    private Phone phone;


    public Student(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }






}
