package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.MarkStudent;

@Repository
public interface MarkStudentRepository extends JpaRepository<MarkStudent,Long> {
}
