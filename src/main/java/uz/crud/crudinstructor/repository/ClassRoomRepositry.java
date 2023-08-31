package uz.crud.crudinstructor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.ClassRoom;

@Repository
public interface ClassRoomRepositry extends CrudRepository<ClassRoom, Long> {
    boolean existsByName(String name);

}
