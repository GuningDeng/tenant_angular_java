package com.deng.tenantapi.application.cqrs.tenants;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.CommandHandler;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Service
public class AddTenantCommandHandler implements CommandHandler<AddTenantCommand> {

    private final ModelMapper modelMapper;
    private final TenantRepository tenantRepository;
    private final HousingRepository housingRepository;   

    public AddTenantCommandHandler(TenantRepository tenantRepository, HousingRepository housingRepository, ModelMapper modelMapper) {
        this.tenantRepository = tenantRepository;
        this.housingRepository = housingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void handle(AddTenantCommand t) {
        boolean existing = tenantRepository.findAll().stream().filter(te -> te.getMobile().equalsIgnoreCase(t.getTenantDetailDto().getMobile())).findFirst().isPresent();
        Housing existingHousing = housingRepository.findById(t.getTenantDetailDto().getHousing().getId()).orElseThrow(()-> new RuntimeException("housing does not exist"));
        Long tenantId = existingHousing.getTenantId();

        Tenant tenant = new Tenant();
        System.out.println("t.getHousing() ->: " + t.getTenantDetailDto().getHousing().getHousNumber());
        
        if (tenantId != 0L) {
            throw new RuntimeException("housing is not available");
        } else if (existing) {
            throw new RuntimeException("tenant exists");
        } else {
            tenant.setIdCard(t.getTenantDetailDto().getIdCard());
            tenant.setMobile(t.getTenantDetailDto().getMobile());
            tenant.setRentDateTime(t.getTenantDetailDto().getRentDateTime());
            tenant.setHousing(modelMapper.map(t.getTenantDetailDto().getHousing(), Housing.class));
            tenantRepository.save(tenant);

            Housing housing = modelMapper.map(t.getTenantDetailDto().getHousing(), Housing.class);

            Tenant savedTenant = tenantRepository.findAll().stream().filter(te -> te.getMobile().equalsIgnoreCase(t.getTenantDetailDto().getMobile())).findFirst().orElseThrow(() -> new RuntimeException("tenant with this mobile does not exist"));
            if (savedTenant != null) {
                Housing updateHousing = new Housing(housing.getId(), housing.getHousNumber(), housing.getOwner(), housing.getIdCard(), savedTenant.getId());
                housingRepository.save(updateHousing);
            }
            
        }      
        
    }
    
    
}
