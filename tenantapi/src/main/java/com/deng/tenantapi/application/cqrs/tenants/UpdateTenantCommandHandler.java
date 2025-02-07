package com.deng.tenantapi.application.cqrs.tenants;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class UpdateTenantCommandHandler implements CommandHandler<UpdateTenantCommand>{
    private final TenantRepository tenantRepository;

    public UpdateTenantCommandHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void handle(UpdateTenantCommand t) {
        Tenant existing = tenantRepository.findById(t.getTenant().getId()).orElseThrow(()-> new RuntimeException("tenant does not exist")); 
        Tenant updateTenant = t.getTenant();

        existing.setId(updateTenant.getId());
        existing.setIdCard(updateTenant.getIdCard());
        existing.setMobile(updateTenant.getMobile());
        existing.setHousing(updateTenant.getHousing());

        tenantRepository.save(existing);
    }
    
    
}
