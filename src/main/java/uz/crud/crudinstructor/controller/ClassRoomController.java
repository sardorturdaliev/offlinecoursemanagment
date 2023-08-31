package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.ClassRoomRequestDto;
import uz.crud.crudinstructor.entity.ClassRoom;
import uz.crud.crudinstructor.service.ClassRoomService;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @PostMapping("/createClassRoom")
    public ResponseEntity<String> addClassRoom(@RequestBody ClassRoomRequestDto classRoomRequestDto) {
        String result = classRoomService.add(classRoomRequestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getClassRoom")
    public ResponseEntity<List<ClassRoom>> getAllClassRoom() {
        List<ClassRoom> classRooms = classRoomService.getAllClassRoom();
        return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

    @GetMapping("/getClassRoom/{id}")
    public ResponseEntity<ClassRoom> getClassRoom(@PathVariable Long id) {
        ClassRoom classRoom = classRoomService.getClassRoom(id);
        return new ResponseEntity<>(classRoom, HttpStatus.OK);
    }

    @PutMapping("/updateClassRoom/{id}")
    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable Long id, @RequestBody ClassRoomRequestDto classRoomRequestDto) {
        ClassRoom classRoom = classRoomService.updateClassRoom(id, classRoomRequestDto);
        return new ResponseEntity<>(classRoom, HttpStatus.OK);
    }

    @DeleteMapping("/deleteClassRoom/{id}")
    public ResponseEntity<String> deleteClassRoom(@PathVariable Long id) {
        String result = classRoomService.deleteClassRoom(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
