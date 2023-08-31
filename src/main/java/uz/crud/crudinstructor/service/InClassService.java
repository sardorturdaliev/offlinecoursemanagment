package uz.crud.crudinstructor.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.crud.crudinstructor.dto.requestDto.InClassDto;
import uz.crud.crudinstructor.dto.requestDto.PutInclassRequestDto;
import uz.crud.crudinstructor.dto.requestDto.StudentClassDto;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.repository.InClassRepostiry;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InClassService {

    private InClassRepostiry repostiry;
    private StudentClassService studentClassService;

    @Autowired
    public InClassService(InClassRepostiry repostiry, StudentClassService studentClassService) {
        this.repostiry = repostiry;
        this.studentClassService = studentClassService;
    }


    public String createInClass(InClassDto inClassDto) {
        InClass inClass = new InClass();
        inClass.setName(inClassDto.getName());
        inClass.setPassword(inClassDto.getPassword());
        inClass.setStatus(inClassDto.getStatus());
        inClass.setPresent(inClassDto.getPresent());
        StudentClass studentClass = studentClassService.getStudentClass(inClassDto.getStudentclassid());
        inClass.setStudentClass(studentClass);
        repostiry.save(inClass);
        return "Success";
    }

    public List<InClass> getAll() {
        List<InClass> list = repostiry.findAll();
        return list;
    }

    public InClass getInClass(Long id) {
        Optional<InClass> inClass = repostiry.findById(id);
        return inClass.get();
    }

    public List<InClass> getClassStudent(Long id) {
        //get  all data
        List<InClass> allInClasses = repostiry.findAll();
        return allInClasses.stream().
                filter(inClass -> inClass.getStudentClass().getId() == id)
                .collect(Collectors.toList());
    }

    public List<InClass> findByName(String name) {
        List<InClass> allInclasses = repostiry.findAll();
        return allInclasses.stream().filter(inclasses -> inclasses.getName().contains(name)).collect(Collectors.toList());
    }


    @Transactional
    public InClass editInClass(PutInclassRequestDto inClassDto){
        InClass inClass = getInClass(inClassDto.getId());
        inClass.setName(inClassDto.getName());
        inClass.setPassword(inClassDto.getPassword());
        inClass.setStatus(inClassDto.getStatus());
        StudentClass studentClass = studentClassService.getStudentClass(inClassDto.getStudentclassid());
        inClass.setStudentClass(studentClass);
        return inClass;
    }



}
