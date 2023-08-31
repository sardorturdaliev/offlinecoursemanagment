package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Lesson;

@Repository
public interface LessonRepositor extends JpaRepository<Lesson, Long> {
}
