package com.deng.tenantapi.application.cqrs.tenants;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class AddTenantCommandHandler implements CommandHandler<AddTenantCommand> {
    private final TenantRepository tenantRepository;
    private final HousingRepository housingRepository;   

    public AddTenantCommandHandler(TenantRepository tenantRepository, HousingRepository housingRepository) {
        this.tenantRepository = tenantRepository;
        this.housingRepository = housingRepository;
    }

    @Override
    public void handle(AddTenantCommand t) {
        boolean existing = tenantRepository.findAll().stream().filter(te -> te.getMobile().equalsIgnoreCase(t.getMobile())).findFirst().isPresent();
        Housing existingHousing = housingRepository.findById(t.getHousing().getId()).orElseThrow(()-> new RuntimeException("housing does not exist"));
        Long tenantId = existingHousing.getTenantId();

        Tenant tenant = new Tenant();
        System.out.println("t.getHousing() ->: " + t.getHousing().getHousNumber());
        
        if (tenantId != 0L) {
            throw new RuntimeException("housing is not available");
        } else if (existing) {
            throw new RuntimeException("tenant exists");
        } else {
            tenant.setIdCard(t.getIdCard());
            tenant.setMobile(t.getMobile());
            tenant.setRentDateTime(t.getRentDateTime());
            tenant.setHousing(t.getHousing());
            tenantRepository.save(tenant);

            Housing housing = t.getHousing();

            Tenant savedTenant = tenantRepository.findAll().stream().filter(te -> te.getMobile().equalsIgnoreCase(t.getMobile())).findFirst().orElseThrow(() -> new RuntimeException("tenant with this mobile does not exist"));
            if (savedTenant != null) {
                Housing updateHousing = new Housing(housing.getId(), housing.getHousNumber(), housing.getOwner(), housing.getIdCard(), savedTenant.getId());
                housingRepository.save(updateHousing);
            }
            
        }      
        
    }
    
    
}
