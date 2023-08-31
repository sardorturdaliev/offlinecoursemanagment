package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.FileData;

@Repository
public interface FileDataRepository  extends JpaRepository<FileData,Long> {

}
