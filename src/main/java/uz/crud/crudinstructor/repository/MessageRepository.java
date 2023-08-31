package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

}
