package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String role;
    private Boolean status = true;
    @JsonIgnore
    private String password;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;




}
