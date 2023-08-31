package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.ImageData;

import java.util.Optional;

@Repository
public interface StorageRepository  extends JpaRepository<ImageData,Long>
{
    Optional<ImageData> findByName(String fileName);
}
