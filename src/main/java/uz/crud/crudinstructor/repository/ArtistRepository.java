package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
