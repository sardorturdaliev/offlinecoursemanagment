package uz.crud.crudinstructor.service;

import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.CityRequestDto;
import uz.crud.crudinstructor.entity.City;

import java.util.List;

@Service
public interface CityService {
    public City addCity(CityRequestDto cityRequestDto);

    public List<City> getCities();

    public City getCity(Long id);

    public City deleteCity(Long id);

    public City editCity(Long id,CityRequestDto cityRequestDto);

}
