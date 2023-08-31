package uz.crud.crudinstructor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {

}
