package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.HomeWorkDto;
import uz.crud.crudinstructor.dto.responseDto.HomeWorksResponse;
import uz.crud.crudinstructor.entity.*;
import uz.crud.crudinstructor.repository.HomeWorkRepositorry;
import uz.crud.crudinstructor.repository.MarkStudentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeWorkService {
    private HomeWorkRepositorry repositorry;
    private TopicsService topicsService;
    private StudentClassService studentClassService;

    private MarkStudentRepository markStudentRepository;
    private MarkStudentService markStudentService;

    private InClassService inClassService;


    @Autowired
    public HomeWorkService(HomeWorkRepositorry repositorry, TopicsService topicsService, StudentClassService studentClassService, MarkStudentRepository markStudentRepository, InClassService inClassService, MarkStudentService markStudentService) {
        this.repositorry = repositorry;
        this.topicsService = topicsService;
        this.studentClassService = studentClassService;
        this.markStudentRepository = markStudentRepository;
        this.inClassService = inClassService;
        this.markStudentService = markStudentService;
    }


    public String addHomeWork(HomeWorkDto homeWorkDto) {
        Homework homework = new Homework();
        homework.setHomeworkmessage(homeWorkDto.getHomeworkmessage());
        homework.setDeadline(homeWorkDto.getDeadline());
        homework.setCreateddate(homeWorkDto.getCreateddate());
        Topics topics = topicsService.getTopic(homeWorkDto.getTopics_id());
        StudentClass studentClass = studentClassService.getStudentClass(homeWorkDto.getStudentClass_id());
        homework.setTopics(topics);
        homework.setStudentClass(studentClass);
        repositorry.save(homework);

        //Get Students by class id
        List<InClass> inClassList = inClassService.getClassStudent(homeWorkDto.getStudentClass_id());
 /*
  Save Student Marks
  */
        for (InClass inClass : inClassList) {
            MarkStudent markStudent = new MarkStudent(inClass.getName(), 0, homework, 0, studentClass);
            markStudentRepository.save(markStudent);
        }
        return "Home Work Added";
    }

    public HomeWorksResponse getHomeWorks(Long topicId) {
        // Get data by topic id
        List<Homework> list = repositorry.findAll().stream().filter(homeworks -> homeworks.getTopics().getTopic_id() == topicId).collect(Collectors.toList());
        List<Homework> homeworkList = new ArrayList<>();

        for (Homework homework : list) {// id 1
            MarkStudentSum markedStudentSum = markStudentService.getMarkedStudentSum(homework.getHomework_id());// 1
            Homework homework1 = new Homework(
                    homework.getHomework_id(),
                    homework.getTopics(),
                    homework.getStudentClass(),
                    homework.getHomeworkmessage(),
                    homework.getDeadline(),
                    homework.getCreateddate(),
                    markedStudentSum.getMaxStudent(), markedStudentSum.getMarkedStudentSum());
            homeworkList.add(homework1);
        }
        int homeworkcount = list.size();
        List<HomeWorksResponse> homeWorksResponseList = new ArrayList<>();
        HomeWorksResponse homeWorksResponse = new HomeWorksResponse(homeworkcount, homeworkList);
        homeWorksResponseList.add(homeWorksResponse);
        return homeWorksResponseList.get(0);
    }

    public List<Homework> getHomeworkByDate(Long studentClassId, String createddate){
//        List<Homework> list = repositorry.findAll().stream().filter(homeworks -> homeworks.getStudentClass().getId() == studentClassId).collect(Collectors.toList());
        List<Homework> list = repositorry.findBystudentClassIdAndCreateddate(studentClassId,createddate);
        return list;
    }




}
