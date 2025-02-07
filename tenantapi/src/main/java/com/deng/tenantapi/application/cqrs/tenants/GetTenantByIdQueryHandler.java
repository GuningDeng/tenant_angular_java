package com.deng.tenantapi.application.cqrs.tenants;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class GetTenantByIdQueryHandler implements QueryHandler<GetTenantByIdQuery, Tenant> {
    private final TenantRepository tenantRepository;

    public GetTenantByIdQueryHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Tenant handle(GetTenantByIdQuery query) {
        Tenant tenant = tenantRepository.findById(query.getId()).orElseThrow(()-> new RuntimeException("tenant does not exist"));
        
        return tenant;
    }
    
}
