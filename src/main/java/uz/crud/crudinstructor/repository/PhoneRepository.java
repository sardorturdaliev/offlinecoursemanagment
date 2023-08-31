package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

}
