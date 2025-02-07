package com.deng.tenantapi.infrastructure.init;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    private final HousingRepository housingRepository;
    private final TenantRepository tenantRepository;
    
    public DataInitializer(HousingRepository housingRepository, TenantRepository tenantRepository) {
        this.housingRepository = housingRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save initial Housing data
        Housing housing1 = new Housing(null, "66", "Jan Jannson", "123456789", 1L);
        Housing housing2 = new Housing(null, "88", "Aan van Hovman", "234567891", 2L);
        Housing housing3 = new Housing(null, "158", "Bart Peeters", "289768990", 0L);
        housingRepository.save(housing1);
        housingRepository.save(housing2);
        housingRepository.save(housing3);

        // Create and save initial Tenant data
        Tenant tenant1 = new Tenant(null, "ID12345", "123-456-7890", LocalDateTime.now(), housing1);
        Tenant tenant2 = new Tenant(null, "ID67890", "098-765-4321", LocalDateTime.now(), housing2);
        tenantRepository.save(tenant1);
        tenantRepository.save(tenant2);
        
    } 
    
}
