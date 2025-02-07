package com.deng.tenantapi.application.cqrs.housings;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class AddHousingCommndHandler implements CommandHandler<AddHousingCommand> {
    private final HousingRepository housingRepository;
    private final ModelMapper mapper;

    public AddHousingCommndHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public void handle(AddHousingCommand t) {
        boolean existing = housingRepository.findAll().stream().filter(h -> h.getHousNumber().equalsIgnoreCase(t.getHousing().getHousNumber())).findFirst().isPresent(); 
        
        if (existing) {
            throw new RuntimeException("housing already exists");
        }
        
        Housing housing = mapper.map(t.getHousing(), Housing.class);
        housingRepository.save(housing);
        
    }

       
    
    
}
