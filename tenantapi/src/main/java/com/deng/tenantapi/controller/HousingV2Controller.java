package com.deng.tenantapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.domein.Housing;
import com.deng.tenantapi.domein.JsonResult;
import com.deng.tenantapi.repository.HousingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
@RequestMapping("housing/v2")
public class HousingV2Controller {
    @Autowired
    private HousingRepository housingRepository;

    @SuppressWarnings("rawtypes")
    @GetMapping("/locationList")
    public JsonResult<List> getHousingList() {
        List<Housing> housings = housingRepository.findAll();
        return new JsonResult<>(housings, "get list successfully");
    }

    @GetMapping("/location/{id}")
    public JsonResult<Housing> getHousing(@PathVariable Long id) {
        Optional<Housing> housOptional = housingRepository.findById(id);
        return new JsonResult<>(housOptional.get());
    }
    
    @SuppressWarnings("rawtypes")
    @GetMapping("/locationMap/{id}")
    public JsonResult<Map> gethousingMap(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        Optional<Housing> housingOptional = housingRepository.findById(id);
        map.put("About the housing", housingOptional.get());
        map.put("link", "link address");
        map.put("views", 110);
        return new JsonResult<>(map);
    }
    
    
}
