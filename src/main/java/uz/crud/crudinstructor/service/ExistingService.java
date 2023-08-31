package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.ExistingDto;
import uz.crud.crudinstructor.entity.*;
import uz.crud.crudinstructor.repository.ExistingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExistingService {
    private ExistingRepository repository;
    private StudentClassService studentClassService;
    private InClassService inClassService;

    @Autowired
    public ExistingService(ExistingRepository repository, StudentClassService studentClassService, InClassService inClassService) {
        this.repository = repository;
        this.studentClassService = studentClassService;
        this.inClassService = inClassService;
    }


    public String addexisting(ExistingDto existingDto) {
        StudentClass studentClass = studentClassService.getStudentClass(existingDto.getStudentClass_id());
        Existing existing = new Existing();
        existing.setDate(existingDto.getDate());
        existing.setStudentClass(studentClass);
        existing.setStudentExisting(existingDto.getStudent_existing());
        repository.save(existing);
        return "Success";
    }

    public Existing getExisting(Long classid, String date) {
//        //get All existing
//        List<Existing> existingList = repository.findAll();
//        //get student by classId
//        return existingList.stream().filter(classStudent -> classStudent.getStudentClass().getId() == classid && classStudent.getDate().equals(date)).collect(Collectors.toList());
        if (Objects.isNull(repository.findBystudentClass_idAndDate(classid, date))) {
            return new Existing();
        }
        return repository.findBystudentClass_idAndDate(classid, date);
    }


    public ExistingProsent getExistingProsennt(Long classId, String date) {
        Existing existing = repository.findBystudentClass_idAndDate(classId, date);

        if (Objects.isNull(repository.findBystudentClass_idAndDate(classId, date))) {
            ExistingProsent existingProsent = new ExistingProsent();
            return null;
        }

        int presentcounter = 0;
        int absentcounter = 0;
        int maxExisting = existing.getStudentExisting().size();

        for (StudentExisting studentExisting : existing.getStudentExisting()) {
            if (studentExisting.getPresent()) {
                presentcounter++;
            } else {
                absentcounter++;
            }
        }
        ExistingProsent existingProsent = new ExistingProsent(maxExisting, presentcounter, absentcounter);
        return existingProsent;
    }


    public List<ExistingDate> getStudentExistingDate(String studentName, Long classId) {
        // get Student by date and class
        List<Existing> existingList = repository.findAll().stream().filter(existing -> existing.getStudentClass().getId() == classId).collect(Collectors.toList());
        List<ExistingDate> existingDateList = new ArrayList<>();

        for (Existing existing : existingList) {
            for (StudentExisting studentExisting : existing.getStudentExisting()) {
                if (studentExisting.getName().equals(studentName)){
                    ExistingDate existingDate = new ExistingDate(existing.getDate(),studentExisting.getPresent());
                    existingDateList.add(existingDate);
                }
            }
        }
        return existingDateList;
    }


}
