package uz.crud.crudinstructor.service;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.error.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.entity.MarkStudent;
import uz.crud.crudinstructor.entity.MarkStudentSum;
import uz.crud.crudinstructor.entity.StudentClass;
import uz.crud.crudinstructor.repository.MarkStudentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MarkStudentService {
    private MarkStudentRepository repository;

    @Autowired
    public MarkStudentService(MarkStudentRepository repository) {
        this.repository = repository;
    }


    public List<MarkStudent> getMarksbyHomeWork(Long homework_id) {
        List<MarkStudent> markStudentsList = repository.findAll();
        return markStudentsList.stream().filter(markStudent -> markStudent.getHomework().getHomework_id().equals(homework_id)).collect(Collectors.toList());
    }


    public MarkStudent edit(MarkStudent markStudent) {// Sardor  55
        MarkStudent editMarks = getMarkStudent(markStudent.getMarkstudent_id());// Sardor   20
        editMarks.setHomework(editMarks.getHomework());
        editMarks.setBall(markStudent.getBall());
        editMarks.setName(markStudent.getName());
        return repository.save(editMarks);
    }


    public MarkStudent getMarkStudent(Long id) {
        Optional<MarkStudent> markStudent = repository.findById(id);
        return markStudent.get();
    }

    public List<MarkStudent> getRatting(Long studentclass_id) {
        //get All marks Student
        List<MarkStudent> markStudentList = repository.findAll().stream().filter(students -> students.getStudentClass().getId() == studentclass_id).collect(Collectors.toList());
        List<MarkStudent> scoredStudent = new ArrayList<>();
        Map<String, Integer> studentscore = new HashMap<>();

        for (MarkStudent markStudent : markStudentList) {
            int score = markStudent.getBall();
            studentscore.put(markStudent.getName(), studentscore.getOrDefault(markStudent.getName(), 0) + score);
        }

        for (Map.Entry<String, Integer> entry : studentscore.entrySet()) {
            String markStudentObject = entry.getKey();
            int total = entry.getValue();
            MarkStudent markStudent = new MarkStudent(markStudentObject, 0, null, total, null);
            scoredStudent.add(markStudent);
        }
        return scoredStudent;
    }


    public MarkStudentSum getMarkedStudentSum(Long homeworkId) {
        //get data by homeworkid
        List<MarkStudent> markStudentsList = repository.findAll().stream().filter(markStudent -> markStudent.getHomework().getHomework_id().equals(homeworkId)).collect(Collectors.toList());
        int markedStudentSum = 0;
        int maxstudent = markStudentsList.size();

        for (MarkStudent markStudent : markStudentsList) {
            if (markStudent.getBall() > 0) {
                markedStudentSum++;
            }
        }


        if (markedStudentSum > 0) {
            return new MarkStudentSum(markedStudentSum, maxstudent);
        }

        return new MarkStudentSum(0, maxstudent);
    }


    public List<MarkStudent> getMarkStudentOrder(Long classId) {
        List<MarkStudent> markStudentList = getRatting(classId);
        markStudentList.sort(Comparator.comparing(MarkStudent::getJeneralball).reversed());
        return markStudentList;
    }


    public MarkStudent getMaxBallStudent(Long classId) {
        List<MarkStudent> markStudentList = getRatting(classId);
        return markStudentList.stream().max(Comparator.comparingInt(MarkStudent::getJeneralball)).orElse(new MarkStudent());
    }

}