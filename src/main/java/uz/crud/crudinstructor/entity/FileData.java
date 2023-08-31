package uz.crud.crudinstructor.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String filepath;





}
