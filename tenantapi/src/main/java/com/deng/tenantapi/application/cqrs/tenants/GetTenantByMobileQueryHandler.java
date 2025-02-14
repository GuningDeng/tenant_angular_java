package com.deng.tenantapi.application.cqrs.tenants;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.application.dto.TenantDto;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class GetTenantByMobileQueryHandler implements QueryHandler<GetTenantByMobileQuery, TenantDto>{
    private final TenantRepository tenantRepository;
    private final ModelMapper mapper;

    public GetTenantByMobileQueryHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public TenantDto handle(GetTenantByMobileQuery query) {
        Tenant tenant = tenantRepository.findAll().stream().filter(t -> t.getMobile().equalsIgnoreCase(query.getMobile())).findFirst().orElseThrow(()-> new RuntimeException("tenant does not exist"));
        
        return mapper.map(tenant, TenantDto.class);
    }
    
}
