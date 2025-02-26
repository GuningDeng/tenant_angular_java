package com.deng.tenantapi.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.tenantapi.application.dto.TenantDto;
import com.deng.tenantapi.domain.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<TenantDto> findTenantDtoByMobile(String mobile);
    List<Tenant> findByRentDateTime(LocalDateTime rentDateTime);
    Optional<Tenant> findByMobile(String mobile);
}
