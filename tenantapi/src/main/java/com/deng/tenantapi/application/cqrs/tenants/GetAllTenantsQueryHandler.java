package com.deng.tenantapi.application.cqrs.tenants;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.application.dto.TenantDetailDto;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class GetAllTenantsQueryHandler implements QueryHandler<GetAllTenantsQuery, List<TenantDetailDto>> {
    private final TenantRepository tenantRepository;
    private final ModelMapper mapper;

    public GetAllTenantsQueryHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<TenantDetailDto> handle(GetAllTenantsQuery query) {
        List<Tenant> tenants = tenantRepository.findAll();
        return tenants.stream().map(ten -> mapper.map(ten, TenantDetailDto.class)).toList();
        
    }
    
}
