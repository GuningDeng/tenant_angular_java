package com.deng.tenantapi.application.cqrs.tenants;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.application.dto.TenantDetailDto;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class GetTenantByIdQueryHandler implements QueryHandler<GetTenantByIdQuery, TenantDetailDto> {
    private final TenantRepository tenantRepository;
    private final ModelMapper mapper;

    public GetTenantByIdQueryHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public TenantDetailDto handle(GetTenantByIdQuery query) {
        Tenant tenant = tenantRepository.findById(query.getId()).orElseThrow(()-> new RuntimeException("tenant does not exist"));
        
        return mapper.map(tenant, TenantDetailDto.class);
    }
    
}
