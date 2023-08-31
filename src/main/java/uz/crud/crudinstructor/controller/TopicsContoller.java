package uz.crud.crudinstructor.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.TopicDto;
import uz.crud.crudinstructor.entity.Topics;
import uz.crud.crudinstructor.service.TopicsService;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsContoller {
    private TopicsService service;

    @Autowired
    public TopicsContoller(TopicsService topicsService) {
        this.service = topicsService;
    }


    @PostMapping("/create_Topics")
    @Schema(description = "Create Topics")
    public ResponseEntity<String> createTopics(@RequestBody TopicDto topicDto) {
        String result = service.addTopics(topicDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getTopics")
    @Schema(description = "Get All Topics")
    public ResponseEntity<List<Topics>> getAllTopics() {
        List<Topics> list = service.getTopics();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/getTopicbyLesson")
    public ResponseEntity<List<Topics>> getTopicsbyLesson(@Schema(description = "Get Topics By Lesson",defaultValue = "0") @RequestParam Long lessonid) {
        List<Topics> list = service.getTopicByLesson(lessonid);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
