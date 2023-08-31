package uz.crud.crudinstructor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Zipcode;

@Repository
public interface ZipCodeRepository extends CrudRepository<Zipcode, Long> {

}
