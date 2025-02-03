package com.deng.tenantapi.application.cqrs.housings;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class GetAllHousingsQueryHandler implements QueryHandler<GetAllHousingsQuery, List<Housing>> {
    private final HousingRepository housingRepository;

    public GetAllHousingsQueryHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public List<Housing> handle(GetAllHousingsQuery t) {
        
        return housingRepository.findAll();
    }

    
    
}
