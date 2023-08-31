package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CreateUser {
    @Id
    private Long id;
    private String username;
    private Boolean status;
    private String role;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
