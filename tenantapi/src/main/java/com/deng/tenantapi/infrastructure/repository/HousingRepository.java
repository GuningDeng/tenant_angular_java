package com.deng.tenantapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.tenantapi.application.dto.HousingDto;
import com.deng.tenantapi.domain.Housing;
import java.util.List;


public interface HousingRepository extends JpaRepository<Housing, Long> {
    List<HousingDto> findHousingsByOwner(String owner);
    boolean existsByHousNumber(String houseNumber);
}
