package uz.crud.crudinstructor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.crud.crudinstructor.entity.InClass;

import java.util.List;

@Repository
public interface InClassRepostiry extends JpaRepository<InClass,Long> {
    List<InClass> findByStudentClassId(Long id);
    public InClass findByname(String name);
}
