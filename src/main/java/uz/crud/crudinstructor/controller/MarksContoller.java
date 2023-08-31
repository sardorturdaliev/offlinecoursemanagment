package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.MarksDto;
import uz.crud.crudinstructor.dto.responseDto.MarksResponseDto;
import uz.crud.crudinstructor.entity.Marks;
import uz.crud.crudinstructor.service.MarksService;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksContoller {
    private final MarksService service;

    @Autowired
    public MarksContoller(MarksService service) {
        this.service = service;
    }

    @PostMapping("/add_Marks")
    public ResponseEntity<String> createMarks(@RequestBody MarksDto marksDto) {
        String result = service.addMark(marksDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<MarksResponseDto>> getAllMarks() {
        List<MarksResponseDto> list = service.getallMarks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getMarkets/{classId}")
    public ResponseEntity<List<MarksResponseDto>> getMarkets(@PathVariable Long classId) {
        List<MarksResponseDto> list = service.getMarks(classId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
