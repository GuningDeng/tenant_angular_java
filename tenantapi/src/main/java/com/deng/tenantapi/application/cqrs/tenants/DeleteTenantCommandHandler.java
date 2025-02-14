package com.deng.tenantapi.application.cqrs.tenants;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class DeleteTenantCommandHandler implements CommandHandler<DeleteTenantCommand> {
    private final TenantRepository tenantRepository;

    public DeleteTenantCommandHandler(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void handle(DeleteTenantCommand t) {
        Tenant existing = tenantRepository.findById(t.getId()).orElseThrow(()-> new RuntimeException("tenant does not exist"));
        tenantRepository.delete(existing);
        
    }
    
}
