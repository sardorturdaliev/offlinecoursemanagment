package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.crud.crudinstructor.dto.requestDto.ZipcodeRequestDto;
import uz.crud.crudinstructor.entity.City;
import uz.crud.crudinstructor.entity.Zipcode;
import uz.crud.crudinstructor.repository.ZipCodeRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {
    private final ZipCodeRepository zipCodeRepository;
    private final CityService cityService;

    @Autowired
    public ZipCodeServiceImpl(ZipCodeRepository zipCodeRepository, CityService cityService) {
        this.zipCodeRepository = zipCodeRepository;
        this.cityService = cityService;
    }


    @Override
    public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto) {//name = 10010, cityid = 1
        Zipcode zipcode = new Zipcode();
        zipcode.setName(zipcodeRequestDto.getName()); // name  = 10010
        if (zipcodeRequestDto.getCityId() == null) {
            return zipCodeRepository.save(zipcode);
        }
        //get city by id
        City city = cityService.getCity(zipcodeRequestDto.getCityId());// name Farg'ona   id 1
        zipcode.setCity(city);
        return zipCodeRepository.save(zipcode);

        /*
          {
           "name":"10010",
            city:{
                "id"  : 1,
                "name":"Farg'ona"
             }
          }


         */
    }

    @Override
    public List<Zipcode> getZipcodes() {
        return StreamSupport.stream(zipCodeRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Zipcode getZipCode(Long zipcodeid) {
        return zipCodeRepository.findById(zipcodeid).orElseThrow(() -> new IllegalArgumentException("Could not found"));
    }

    @Override
    public Zipcode deleteZipcode(Long id) {
        Zipcode zipcode = getZipCode(id);
        zipCodeRepository.delete(zipcode);
        return zipcode;
    }

    @Transactional
    @Override
    public Zipcode editZipcode(Long id, ZipcodeRequestDto zipcodeRequestDto) {
        Zipcode zipcodeToEdit = getZipCode(id);
        zipcodeToEdit.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() != null) {
            return zipcodeToEdit;
        }
        City city = cityService.getCity(id);
        zipcodeToEdit.setCity(city);
        return zipcodeToEdit;
    }

    @Transactional
    @Override
    public Zipcode addCitytoZipcode(Long zipcodeid, Long cityid) {
        //get object id
        Zipcode zipcode = getZipCode(zipcodeid);
        City city = cityService.getCity(cityid);

        if (Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zip code already has a city");
        }
        zipcode.setCity(city);
        return zipcode;
    }

    @Override
    public Zipcode removeCityFromZipCode(Long zipCodeid) {
        Zipcode zipcode = getZipCode(zipCodeid);

        if (!Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zip code does not a city");
        }
        zipcode.setCity(null);
        return zipcode;
    }
}
