package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String classname;
    private Boolean status = true;



//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user;




    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;



}
