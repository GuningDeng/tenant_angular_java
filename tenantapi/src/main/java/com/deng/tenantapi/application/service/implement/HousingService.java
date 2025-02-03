package com.deng.tenantapi.application.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.dto.HousingDto;
import com.deng.tenantapi.application.service.IHousingService;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class HousingService implements IHousingService {
    private final HousingRepository housingRepository;

    public HousingService(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public void deleteHousingById(Long id) {
        housingRepository.deleteById(id);
        
    }

    @Override
    public boolean existHousing(String housNumber, String owner, String idcard) {
        return false;
    }

    @Override
    public List<HousingDto> findHousingsByOwner(String owner) {
        List<Housing> housings = housingRepository.findAll().stream()
        .filter(h -> h.getOwner().equalsIgnoreCase(owner))
        .toList();
        
        List<HousingDto> housingDtos = new ArrayList<>();
        for (Housing housing : housings) {
            HousingDto housingDto = new HousingDto();
            housingDto.setHousNumber(housing.getHousNumber());
            housingDto.setOwner(housing.getOwner());
            housingDtos.add(housingDto);
        }
        return housingDtos;
    }

    @Override
    public Optional<Housing> findHousingById(Long id) {
        return housingRepository.findById(id);
    }

    @Override
    public List<Housing> findAllHousings() {
        return housingRepository.findAll();
    }

    @Override
    public Housing saveHousing(Housing housing) {
        
        return housingRepository.save(housing);
    }

    @Override
    public Housing updateHousing(Housing housing, Long id) {
        // Check if the Housing exists
        Housing existingHousing = housingRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Housing not found"));
        
        // Update the existing housing's properties
        existingHousing.setHousNumber(housing.getHousNumber());
        existingHousing.setOwner(housing.getOwner());
        existingHousing.setIdCard(housing.getIdCard());

        // save the updated housing
        return housingRepository.save(existingHousing);

    }

    @Override
    public boolean existsByHousNumber(String houseNumber) {
        return housingRepository.existsByHousNumber(houseNumber);
    }

    
    
}
