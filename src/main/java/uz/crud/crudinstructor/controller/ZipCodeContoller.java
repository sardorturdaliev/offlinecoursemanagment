package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.ZipcodeRequestDto;
import uz.crud.crudinstructor.entity.Zipcode;
import uz.crud.crudinstructor.service.ZipCodeService;

import java.util.List;

@RestController
@RequestMapping("/zipcode")
public class ZipCodeContoller {
    private final ZipCodeService zipCodeService;

    @Autowired
    public ZipCodeContoller(ZipCodeService zipCodeService) {
        this.zipCodeService = zipCodeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Zipcode> addZipcode(@RequestBody ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcode = zipCodeService.addZipcode(zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping("/getzipcode")
    public ResponseEntity<List<Zipcode>> getZipcodes() {
        List<Zipcode> zipcodes = zipCodeService.getZipcodes();
        return new ResponseEntity<>(zipcodes, HttpStatus.OK);
    }


}
