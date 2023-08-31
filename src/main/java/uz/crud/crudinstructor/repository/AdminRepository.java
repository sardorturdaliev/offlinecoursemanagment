package uz.crud.crudinstructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByusername(String username);

}
