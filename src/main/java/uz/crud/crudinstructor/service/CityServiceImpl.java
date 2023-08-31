package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.crud.crudinstructor.dto.requestDto.CityRequestDto;
import uz.crud.crudinstructor.entity.City;
import uz.crud.crudinstructor.exceptions.CityException;
import uz.crud.crudinstructor.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City addCity(CityRequestDto cityRequestDto) {
        City city = new City();
        city.setName(cityRequestDto.getName());
        return cityRepository.save(city);
    }

    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }

    @Override
    public City getCity(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Could not found"));
    }

    @Override
    public City deleteCity(Long id) {
        City city = getCity(id);

        cityRepository.delete(city);
        return city;
    }

    @Transactional
    @Override
    public City editCity(Long id, CityRequestDto cityRequestDto) {
        City citytoEdit = getCity(id);
        citytoEdit.setName(cityRequestDto.getName());
        return citytoEdit;
    }
}
