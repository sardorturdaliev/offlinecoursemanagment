package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
