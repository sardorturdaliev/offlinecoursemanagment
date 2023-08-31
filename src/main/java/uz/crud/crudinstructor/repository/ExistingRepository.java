package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Existing;

import java.util.List;

@Repository
public interface ExistingRepository  extends JpaRepository<Existing,Long> {
    Existing findBystudentClass_idAndDate(Long studentClass_id, String date);

}
