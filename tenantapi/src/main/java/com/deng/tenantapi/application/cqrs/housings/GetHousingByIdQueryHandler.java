package com.deng.tenantapi.application.cqrs.housings;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class GetHousingByIdQueryHandler implements QueryHandler<GetHousingByIdQuery, Housing> {
    private final HousingRepository housingRepository;

    public GetHousingByIdQueryHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public Housing handle(GetHousingByIdQuery query) {
        
        return housingRepository.findById(query.getId()).orElseThrow(() -> new RuntimeException("housing not found"));
    }

    
    
    
}
