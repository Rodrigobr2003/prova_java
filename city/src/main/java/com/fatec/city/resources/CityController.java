package com.fatec.city.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
