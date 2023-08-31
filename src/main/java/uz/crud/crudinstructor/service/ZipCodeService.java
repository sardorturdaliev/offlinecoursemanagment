package uz.crud.crudinstructor.service;

import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.ZipcodeRequestDto;
import uz.crud.crudinstructor.entity.Zipcode;

import java.util.List;

@Service
public interface ZipCodeService {
    public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto);

    public List<Zipcode> getZipcodes();

    public Zipcode getZipCode(Long zipcodeid);

    public Zipcode deleteZipcode(Long id);

    public Zipcode editZipcode(Long id, ZipcodeRequestDto zipcodeRequestDto);

    public Zipcode addCitytoZipcode(Long zipcodeid, Long cityid);

    public Zipcode removeCityFromZipCode(Long zipCodeid);


}
