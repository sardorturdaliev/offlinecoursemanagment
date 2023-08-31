package uz.crud.crudinstructor.service;

import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.TopicDto;
import uz.crud.crudinstructor.entity.Lesson;
import uz.crud.crudinstructor.entity.Topics;
import uz.crud.crudinstructor.repository.TopicsReposutory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicsService {
    private final TopicsReposutory reposutory;
    private final LessonService lessonService;

    public TopicsService(TopicsReposutory reposutory, LessonService lessonService) {
        this.reposutory = reposutory;
        this.lessonService = lessonService;
    }

    public String addTopics(TopicDto topicDto) {
        Topics topics = new Topics();
        topics.setTopicName(topicDto.getTopicName());
        topics.setDate(topicDto.getDate());
        Lesson lesson = lessonService.getLessson(topicDto.getLesson_id());
        topics.setLesson(lesson);
        reposutory.save(topics);
        return "Added";
    }


    public List<Topics> getTopics() {
        List<Topics> list = reposutory.findAll();
        return list;
    }

    public Topics getTopic(Long id) {
        Optional<Topics> topics = reposutory.findById(id);
        return topics.get();
    }

    public List<Topics> getTopicByLesson(Long lessonid) {
        List<Topics> list = reposutory.findAll().stream().filter(lesson -> lesson.getLesson().getLessonid().equals(lessonid)).collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }


}
