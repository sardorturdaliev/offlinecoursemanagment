package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.MessageDto;
import uz.crud.crudinstructor.dto.responseDto.MessageResponse;
import uz.crud.crudinstructor.entity.Message;
import uz.crud.crudinstructor.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageContoller {
    private MessageService messageService;
    @Autowired
    public MessageContoller(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping("/send_message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto) {
        String result = messageService.sendMessage(messageDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping("/getAll_messages")
    public ResponseEntity<List<Message>> getAllMessage() {
        List<Message> list = messageService.getMessages();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/get_own_message/{student_id}")
    public ResponseEntity<List<MessageResponse>> getOwnMessage(@PathVariable Long student_id) {
        List<MessageResponse> list = messageService.getOwnMessages(student_id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
