package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Homework;

import java.util.List;

@Repository
public interface HomeWorkRepositorry extends JpaRepository<Homework, Long> {
    List<Homework> findBystudentClassIdAndCreateddate(Long studentClass_id, String createddate);
}
