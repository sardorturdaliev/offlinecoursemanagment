package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Album;

@Repository
public interface AlbumRepository   extends JpaRepository<Album,Long> {
}
