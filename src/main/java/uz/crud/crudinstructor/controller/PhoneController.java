package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.crud.crudinstructor.entity.Phone;
import uz.crud.crudinstructor.service.PhoneService;
import uz.crud.crudinstructor.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    private PhoneService phoneService;


    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @GetMapping("/getPhones")
    public ResponseEntity<List<Phone>> getPhones() {
        List<Phone> phones = phoneService.getAllPhone();
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Phone> getPhone(@PathVariable Long id) {
        Phone phone = phoneService.getPhoneById(id);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }


}
