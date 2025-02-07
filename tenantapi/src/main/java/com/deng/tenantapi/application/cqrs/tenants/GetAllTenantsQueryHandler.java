package com.deng.tenantapi.application.cqrs.tenants;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class GetAllTenantsQueryHandler implements QueryHandler<GetAllTenantsQuery, List<Tenant>> {
    private final TenantRepository tenantRepository;

    public GetAllTenantsQueryHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public List<Tenant> handle(GetAllTenantsQuery query) {
        
        return tenantRepository.findAll();
    }
    
}
