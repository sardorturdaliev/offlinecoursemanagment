package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.crud.crudinstructor.entity.Phone;
import uz.crud.crudinstructor.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PhoneServiceImpl implements PhoneService {
    private PhoneRepository phoneRepository;


    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }


    @Override
    public List<Phone> getAllPhone() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }


}
