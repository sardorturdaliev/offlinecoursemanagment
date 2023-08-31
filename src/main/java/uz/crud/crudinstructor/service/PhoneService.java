package uz.crud.crudinstructor.service;

import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.entity.Phone;

import java.util.List;

@Service
public interface PhoneService {
    public List<Phone> getAllPhone();
    public Phone getPhoneById(Long id);
}
