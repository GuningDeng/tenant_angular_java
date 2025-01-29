package com.deng.tenantapi.application.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.deng.tenantapi.application.dto.HousingDto;
import com.deng.tenantapi.application.dto.TenantDto;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.domain.Tenant;

import lombok.val;

public interface ITenantService {
    /**
     * seva tenant
     * @param tenant
     * @return
     */
    public Tenant saveTenant(Tenant tenant);

    /**
     * 
     * @return
     */
    public List<Tenant> findTenants();

    /**
     * update Tenant
     * @param tenant
     * @param id
     * @return
     */
    public Tenant updateTenant(Tenant tenant, Long id);

    /**
     * 
     * @param id
     * @return
     */
    public Optional<Tenant> findTenantByid(Long id);

    /**
     * 
     * @param id
     * @return
     */
    public void deleteTenantById(Long id);

    /**
     * 
     * @param idCard
     * @param mobile
     * @param rentDateTime
     * @return
     */
    public boolean existTenant(String idCard, String mobile, LocalDateTime rentDateTime);
    /**
     * get Tenant with: mobile and rentDateTime
     * @param mobile
     * @return
     */
    public TenantDto findTenantDtoByMobile(String mobile);
    /**
     * get Tenants by rentDateTime
     * @param rentDateTime
     * @return
     */
    public List<Tenant> findByRentDateTime(LocalDateTime rentDateTime);
}
