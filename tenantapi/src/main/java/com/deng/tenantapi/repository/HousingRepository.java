package com.deng.tenantapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.tenantapi.domein.Housing;

public interface HousingRepository extends JpaRepository<Housing, Long> {
    
}
