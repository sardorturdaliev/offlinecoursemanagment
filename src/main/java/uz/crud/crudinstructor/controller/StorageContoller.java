package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.crud.crudinstructor.service.StoraageService;

import java.io.IOException;

@RestController
@RequestMapping("/imagFile")
public class StorageContoller {

    @Autowired
    private StoraageService service;




}
