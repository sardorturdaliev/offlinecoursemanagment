package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crud.crudinstructor.entity.Topics;

public interface TopicsReposutory extends JpaRepository<Topics, Long> {
}
