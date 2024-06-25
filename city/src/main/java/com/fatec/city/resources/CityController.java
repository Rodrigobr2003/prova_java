package com.fatec.city.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.city.entities.City;

@RestController
@RequestMapping("cities")
public class CityController {
    
    @GetMapping
    public List<City> getCities(){
        City s1 = new City();
        s1.setId(1);
        s1.setNome("Itu");
        s1.setEstado("SP");
        s1.setPopulacao(100000);
        s1.setPib(300000);

        City s2 = new City();
        s1.setId(2);
        s1.setNome("Itumbiara");
        s1.setEstado("SP");
        s1.setPopulacao(100000);
        s1.setPib(300000);

        ArrayList<City> lista = new ArrayList<City>();
        lista.add(s1);
        lista.add(s2);

        return lista;
    }
}
