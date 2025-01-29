package com.deng.tenantapi.application.service;

import java.util.List;
import java.util.Optional;

import com.deng.tenantapi.application.dto.HousingDto;
import com.deng.tenantapi.domain.Housing;

public interface IHousingService {
    /**
     * 
     * @param housing
     * @return
     */
    public Housing saveHousing(Housing housing);
    /**
     * 
     * @return
     */
    public List<Housing> findAllHousings();
    /**
     * 
     * @param housing
     * @param id
     * @return
     */
    public Housing updateHousing(Housing housing, Long id);
    /**
     * 
     * @param id
     * @return
     */
    public Optional<Housing> findHousingById(Long id);
    /**
     * 
     * @param id
     */
    public void deleteHousingById(Long id);
    /**
     * 
     * @param housNumber
     * @param owner
     * @param idcard
     * @return
     */
    public boolean existHousing(String housNumber, String owner, String idcard);
    /**
     * 
     * @param owner
     * @return
     */
    public List<HousingDto> findHousingsByOwner(String owner); 
    
} 
