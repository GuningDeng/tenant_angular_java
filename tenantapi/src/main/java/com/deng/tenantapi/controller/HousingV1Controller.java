package com.deng.tenantapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.domein.Housing;
import com.deng.tenantapi.repository.HousingRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
@RequestMapping("housing/v1")
public class HousingV1Controller {
    @Autowired
    private HousingRepository housingRepository;

    @GetMapping("/locations")
    public List<Housing> getHousings() {
        List<Housing> housings = housingRepository.findAll();
        return housings;
    }
    
    @GetMapping("/locations/{id}")
    public Housing getHousing(@PathVariable Long id) {
        Optional<Housing> housOptional = housingRepository.findById(id);
        return housOptional.get();
    }
    
}
