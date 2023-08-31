package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.CreateUser;
import uz.crud.crudinstructor.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
}
