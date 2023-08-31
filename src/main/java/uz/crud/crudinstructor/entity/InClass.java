package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Data
public class InClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private Boolean status = true;

    @Column(columnDefinition = "boolean default false")
    private Boolean present = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentClass_id")
    @JsonIgnore
    private StudentClass studentClass;


}
