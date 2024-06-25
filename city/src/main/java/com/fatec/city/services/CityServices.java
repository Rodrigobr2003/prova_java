package com.fatec.city.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.city.dto.CityRequest;
import com.fatec.city.dto.CityResponse;
import com.fatec.city.entities.City;
import com.fatec.city.mapping.CityMapper;
import com.fatec.city.repositories.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityServices {
    
    @Autowired
    private CityRepository cityRepository;

    public List<CityResponse> getCities(){
        List <City> city = cityRepository.findAll();

        return city.stream().map(s -> CityMapper.toDTO(s)).collect(Collectors.toList());
    }

    public CityResponse getCityById(int id){
        City city =  cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cidade não cadastrada"));

        return CityMapper.toDTO(city);
    }

    public void update(int id, CityRequest request){
        try {
            City aux = cityRepository.getReferenceById(id);
            aux.setNome(request.nome());
            aux.setEstado(request.estado());
            aux.setPopulacao(request.populacao());
            aux.setPib(request.pib());

            this.cityRepository.save(aux);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cidade não cadastrada");
        }
    }

    public void deletCityById(int id){
        if(this.cityRepository.existsById(id)){
            this.cityRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Cidade não cadastrada");
        }
    }
}
