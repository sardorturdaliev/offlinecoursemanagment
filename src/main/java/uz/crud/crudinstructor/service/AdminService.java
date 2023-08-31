package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.AdminDto;
import uz.crud.crudinstructor.entity.Admin;
import uz.crud.crudinstructor.repository.AdminRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public String createAdmin(AdminDto admin) {// Sardor
        Admin admin1 = new Admin();
        admin1.setId(admin1.getId());
        admin1.setUsername(admin.getUsername());
        if (adminRepository.findByusername(admin1.getUsername()) != null){
            return "Already Exists";
        }else {
            adminRepository.save(admin1);
        }
        return "Success";
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdmin(Long id) {
        Optional<Admin>  optionalAdmin = adminRepository.findById(id);
        return optionalAdmin.get();
    }


}
