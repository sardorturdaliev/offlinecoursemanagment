package uz.crud.crudinstructor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long albumId;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "artist_id",nullable = false)
    @JsonIgnore
    private Artist artist;


}
