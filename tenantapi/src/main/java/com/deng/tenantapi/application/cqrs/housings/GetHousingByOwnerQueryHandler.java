package com.deng.tenantapi.application.cqrs.housings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.application.dto.HousingDto;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class GetHousingByOwnerQueryHandler implements QueryHandler<GetHousingByOwnerQuery, List<HousingDto>> {
    private final HousingRepository housingRepository;

    public GetHousingByOwnerQueryHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public List<HousingDto> handle(GetHousingByOwnerQuery query) {
        List<Housing> housings = housingRepository.findAll().stream().filter(h -> h.getOwner().equalsIgnoreCase(query.getOwner())).toList();
        List<HousingDto> housingDtos = new ArrayList<>();

        for (Housing housing : housings) {
            HousingDto housingDto = new HousingDto();
            housingDto.setHousNumber(housing.getHousNumber());
            housingDto.setOwner(housing.getOwner());
            housingDtos.add(housingDto);
        }

        return housingDtos;
    }

       
    
    
}
