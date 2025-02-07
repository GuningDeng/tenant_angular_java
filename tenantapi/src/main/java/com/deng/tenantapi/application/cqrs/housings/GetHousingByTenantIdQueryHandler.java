package com.deng.tenantapi.application.cqrs.housings;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class GetHousingByTenantIdQueryHandler implements QueryHandler<GetHousingByTenantIdQuery, List<Housing>> {
    private final HousingRepository housingRepository;

    public GetHousingByTenantIdQueryHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public List<Housing> handle(GetHousingByTenantIdQuery query) {
        List<Housing> housings = housingRepository.findAll().stream().filter(h -> h.getTenantId() == query.getTenantId()).toList();
        return housings;
    }
        
}
