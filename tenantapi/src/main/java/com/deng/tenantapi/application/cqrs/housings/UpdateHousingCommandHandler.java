package com.deng.tenantapi.application.cqrs.housings;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.application.dto.HousingDetailDto;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class UpdateHousingCommandHandler implements CommandHandler<UpdateHousingCommand> {
    private final HousingRepository housingRepository;

    public UpdateHousingCommandHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public void handle(UpdateHousingCommand t) {
        Housing existing = housingRepository.findById(t.getId()).orElseThrow(() -> new RuntimeException("housing not found"));
        HousingDetailDto updateHousing = t.getHousingDetailDto();
        
        existing.setHousNumber(updateHousing.getHousNumber());
        existing.setIdCard(updateHousing.getIdCard());
        existing.setOwner(updateHousing.getOwner());

        housingRepository.save(existing);
    }
    

    
}
