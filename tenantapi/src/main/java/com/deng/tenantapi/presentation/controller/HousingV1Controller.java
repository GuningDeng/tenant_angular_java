package com.deng.tenantapi.presentation.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.dto.HousingDto;
import com.deng.tenantapi.application.service.implement.HousingService;
import com.deng.tenantapi.domain.Housing;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
@RequestMapping("housing/v1")
public class HousingV1Controller {
    private final HousingService housingService;
    

    public HousingV1Controller(HousingService housingService) {
        this.housingService = housingService;
    }

    @GetMapping("/locations")
    public List<Housing> getHousings() {
        List<Housing> housings = housingService.findAllHousings();
        return housings;
    }
    
    @GetMapping("/locations/{id}")
    public Housing getHousing(@PathVariable Long id) {
        Housing housing = housingService.findHousingById(id).orElseThrow(() -> new RuntimeException("housing not found"));
        System.out.println(housing.toString());
        return housing;
    }

    @GetMapping("/locations/byOwner/{owner}")
    public List<HousingDto> getHousingByOwner(@PathVariable String owner) {
        List<HousingDto> housingDtos = housingService.findHousingsByOwner(owner);
        housingDtos.forEach(h -> System.out.println("housing->: " + h.toString()));
        
        return housingDtos;
    }
    
    
}
