package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Marks;
@Repository
public interface MarksReposotory extends JpaRepository<Marks, Long> {
}
