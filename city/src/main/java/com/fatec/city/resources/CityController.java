package com.fatec.city.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.city.dto.CityRequest;
import com.fatec.city.dto.CityResponse;
import com.fatec.city.services.CityServices;

@RestController
@RequestMapping("cities")
public class CityController {
    
    @Autowired
    private CityServices cityServices;

    @GetMapping
    public ResponseEntity<List<CityResponse>> getCities(){
        return ResponseEntity.ok(cityServices.getCities());
    }

    @GetMapping("{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable int id){
        return ResponseEntity.ok(cityServices.getCityById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody CityRequest city){
        this.cityServices.update(id, city);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public void deletCityById(@PathVariable int id){
        this.cityServices.deletCityById(id);
    }
}
