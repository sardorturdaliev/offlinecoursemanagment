package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.StudentClass;

@Repository
public interface StudentClasssRepository extends JpaRepository<StudentClass, Long> {
     StudentClass findByclassname(String classname);
}
