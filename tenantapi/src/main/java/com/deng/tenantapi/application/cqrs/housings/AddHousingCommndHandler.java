package com.deng.tenantapi.application.cqrs.housings;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class AddHousingCommndHandler implements CommandHandler<AddHousingCommand> {
    private HousingRepository housingRepository;

    public AddHousingCommndHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public void handle(AddHousingCommand t) {
        Housing housing = new Housing(null, t.getHousNumber(), t.getOwner(), t.getIdCard());
        housingRepository.save(housing);
    }
    
    
    
}
