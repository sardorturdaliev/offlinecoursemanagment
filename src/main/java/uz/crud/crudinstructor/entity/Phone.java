package uz.crud.crudinstructor.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "tel_number")
    private String number;

    @OneToOne(mappedBy = "phone",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Student student;



}
