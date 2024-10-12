package com.deng.tenantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.tenantapi.domein.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    
}
