package com.deng.tenantapi.application.cqrs.housings;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class DeleteHousingCommandHandler implements CommandHandler<DeleteHousingCommand> {
    private final HousingRepository housingRepository;

    public DeleteHousingCommandHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public void handle(DeleteHousingCommand t) {
        Housing existing = housingRepository.findById(t.getId()).orElseThrow(()-> new RuntimeException("housing does not exist"));
        housingRepository.deleteById(existing.getId());
        
    }
    
    
    
}
