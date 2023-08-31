package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.MessageDto;
import uz.crud.crudinstructor.dto.responseDto.MessageResponse;
import uz.crud.crudinstructor.entity.InClass;
import uz.crud.crudinstructor.entity.Message;
import uz.crud.crudinstructor.entity.User;
import uz.crud.crudinstructor.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository repository;
    private UserService userService;
    private InClassService inClassService;

    @Autowired
    public MessageService(MessageRepository repository, UserService userService, InClassService inClassService) {
        this.repository = repository;
        this.userService = userService;
        this.inClassService = inClassService;
    }

    public String sendMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        User user = userService.getUser(messageDto.getUser_id());
        InClass inClass = inClassService.getInClass(messageDto.getStudent_id());
        message.setUser(user);
        message.setInClass(inClass);
        repository.save(message);
        return "Sended Message";
    }


    public List<Message> getMessages() {
        List<Message> list = repository.findAll();
        return list;
    }

    public List<MessageResponse> getOwnMessages(Long student_id) {
        List<Message> list = repository.findAll().stream().filter(message -> message.getInClass().getId().equals(student_id)).collect(Collectors.toList());
        List<MessageResponse> messageResponseList = new ArrayList<>();
        for (Message message : list) {
            MessageResponse messageResponse = new MessageResponse(message.getMessageId(), message.getMessage(), message.getUser().getUsername());
            messageResponseList.add(messageResponse);
        }
        return messageResponseList;
    }

}
