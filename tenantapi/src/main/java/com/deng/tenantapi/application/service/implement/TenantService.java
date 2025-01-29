package com.deng.tenantapi.application.service.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.dto.TenantDto;
import com.deng.tenantapi.application.service.ITenantService;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class TenantService implements ITenantService {
    private final TenantRepository tenantRepository;
       
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void deleteTenantById(Long id) {
        tenantRepository.deleteById(id);
    }

    @Override
    public boolean existTenant(String idCard, String mobile, LocalDateTime rentDateTime) {
        
        return false;
    }

    @Override
    public Optional<Tenant> findTenantByid(Long id) {
        
        return tenantRepository.findById(id);
    }

    @Override
    public TenantDto findTenantDtoByMobile(String mobile) {
        Tenant tenant = tenantRepository.findAll().stream().
        filter(t -> t.getMobile().equalsIgnoreCase(mobile)).findFirst().orElseThrow(() -> new RuntimeException("tenant not found"));
        TenantDto tenantDto = new TenantDto();
        tenantDto.setMobile(tenant.getMobile());
        tenantDto.setRentDateTime(tenant.getRentDateTime());
        return tenantDto; 
    }

    @Override
    public List<Tenant> findTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public List<Tenant> findByRentDateTime(LocalDateTime rentDateTime) {
        return tenantRepository.findByRentDateTime(rentDateTime);
    }

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public Tenant updateTenant(Tenant tenant, Long id) {
        // Check if the Tenant exists
        Tenant existingTenant = tenantRepository.findById(id).orElseThrow(() -> new RuntimeException("Tenant not found"));

        // Update the existing tenant's properties
        existingTenant.setIdCard(tenant.getIdCard());
        existingTenant.setMobile(tenant.getMobile());
        existingTenant.setRentDateTime(tenant.getRentDateTime());
        existingTenant.setHousing(tenant.getHousing());

        // save the updated tenant
        return tenantRepository.save(existingTenant);
    }
    
    
}
