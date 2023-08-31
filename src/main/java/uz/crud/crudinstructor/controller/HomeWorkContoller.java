package uz.crud.crudinstructor.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.HomeWorkDto;
import uz.crud.crudinstructor.dto.responseDto.HomeWorksResponse;
import uz.crud.crudinstructor.entity.Homework;
import uz.crud.crudinstructor.service.HomeWorkService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/home_Work_operation")
public class HomeWorkContoller {
    private final HomeWorkService homeWorkService;


    public HomeWorkContoller(HomeWorkService homeWorkService) {
        this.homeWorkService = homeWorkService;
    }


    @PostMapping("/create_Home_Work")
    public ResponseEntity<String> addHomeWork(@RequestBody HomeWorkDto homeWorkDto) {
        String result = homeWorkService.addHomeWork(homeWorkDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/get_Home_Work")
    public ResponseEntity<HomeWorksResponse> getHomeWorks(@RequestParam Long topic_Id) {
        HomeWorksResponse item = homeWorkService.getHomeWorks(topic_Id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping("/get_Home_Work_By_Date")
    public ResponseEntity<List<Homework>> getHomeWorksByDate(@Schema(defaultValue = "0",description = "Get Homeworks by Date ") @RequestParam Long studentClassId, String createddate) {
        List<Homework> list = homeWorkService.getHomeworkByDate(studentClassId,createddate);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }




}
