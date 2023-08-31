package uz.crud.crudinstructor.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.ExistingDto;
import uz.crud.crudinstructor.entity.Existing;
import uz.crud.crudinstructor.entity.ExistingDate;
import uz.crud.crudinstructor.entity.ExistingProsent;
import uz.crud.crudinstructor.entity.PresentStudent;
import uz.crud.crudinstructor.service.ExistingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/existing")
public class ExistingContoller {
    private ExistingService service;

    @Autowired
    public ExistingContoller(ExistingService service) {
        this.service = service;
    }

    @PostMapping("/add_Existing")
    public ResponseEntity<String> addExist(@RequestBody ExistingDto existingDto) {
        String result = service.addexisting(existingDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/getExisting_Student")
    public ResponseEntity<Existing> getExisting(@Schema(defaultValue = "0", description = "Get Student by class_id") @RequestParam Long classId,
                                                @RequestParam String datestring
    ) {
        Existing presentStudentList = service.getExisting(classId, datestring);
        if (presentStudentList == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
             
        }
        return new ResponseEntity<>(presentStudentList, HttpStatus.OK);
    }
    @GetMapping("/getExisting_Student_Prosent")
    public ResponseEntity<ExistingProsent> getExistingProsent(@Schema(defaultValue = "0", description = "Get Student by class_id") @RequestParam Long classId, @RequestParam String datestring) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(datestring);   
            ExistingProsent existingProsent = service.getExistingProsennt(classId, datestring);
            return new ResponseEntity<>(existingProsent, HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getExisting_Student_Date")
    public ResponseEntity<List<ExistingDate>> getExistingStudentDate(@RequestParam String name, @RequestParam Long classId) {
        List<ExistingDate> existingList = service.getStudentExistingDate(name, classId);
        return new ResponseEntity<>(existingList, HttpStatus.OK);
    }




}
