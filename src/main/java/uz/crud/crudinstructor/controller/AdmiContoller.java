package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.AdminDto;
import uz.crud.crudinstructor.entity.Admin;
import uz.crud.crudinstructor.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdmiContoller {
    private AdminService adminService;

    @Autowired
    public AdmiContoller(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/add")
    public ResponseEntity<String> createAdmin(@RequestBody AdminDto admin) {
        String createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAdmins() {
        List<Admin> adminList = adminService.getAllAdmins();
        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
        Admin admin = adminService.getAdmin(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }


}
